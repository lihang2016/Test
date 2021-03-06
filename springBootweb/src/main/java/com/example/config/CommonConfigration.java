
package com.example.config;

import ch.qos.logback.classic.pattern.DateConverter;
import com.alibaba.fastjson.parser.ParserConfig;
import com.example.common.udc.StringToUDCConverter;
import com.example.common.udc.UDC;
import com.example.common.udc.UDCDeserializer;
import com.example.mybatisMapper.pages.PageObjectFactory;
import com.example.mybatisMapper.pages.PageObjectWrapperFactory;
import com.example.mybatisMapper.pages.PageableExecutorInterceptor;
import com.example.scaneum.listener.MeataApplicationReadyListener;
import com.example.util.event.EventBus;
import com.example.util.event.EventHandler;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import net.engio.mbassy.bus.config.BusConfiguration;
import net.engio.mbassy.bus.config.Feature;
import net.engio.mbassy.bus.config.IBusConfiguration;
import net.engio.mbassy.bus.error.IPublicationErrorHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PostConstruct;
import javax.servlet.MultipartConfigElement;
import java.util.List;
import java.util.Map;

/**
 *配置事件类
 * 2017年7月5日20:51:46
 */
@Configuration
public class CommonConfigration {

    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;

    @Bean
    public static BeanDefinitionRegistryPostProcessor cpValidatorBeanDefinitionRegistryPostProcessor() {
        return new BeanDefinitionRegistryPostProcessor() {
            @Override
            public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
                ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry, false);
                scanner.addIncludeFilter(new AssignableTypeFilter(EventHandler.class));
                scanner.scan(Splitter.on(",").splitToList("com.example.*").toArray(new String[0]));
            }

            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

            }
        };
    }

    /**
     * 配置responseBody试用fastjson
     * @return
     */
//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters() {
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        //格式化json返回
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        HttpMessageConverter<?> converter = fastConverter;
//        return new HttpMessageConverters(converter);
//    }

    @Bean
    public static BeanPostProcessor cpAppServiceBeanCheckerPostProcessor() {
        return new CPAppServiceBeanCheckerPostProcessor();
    }

    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("1024000MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("102400000MB");
        return factory.createMultipartConfig();
    }
    @Bean
    public ApplicationReadyListener applicationReadyListener() {
        return new ApplicationReadyListener();
    }

    @Bean
    public EventBus messageBus(ContextWrappedExecutorService asyncEventExecutorService) {
        Feature.AsynchronousHandlerInvocation asynchronousHandlerInvocation = new Feature.AsynchronousHandlerInvocation();
        asynchronousHandlerInvocation.setExecutor(asyncEventExecutorService);
        EventBus bus = new EventBus(new BusConfiguration()
                .addFeature(Feature.SyncPubSub.Default())
                .addFeature(asynchronousHandlerInvocation)
                .addFeature(Feature.AsynchronousMessageDispatch.Default())
                .addPublicationErrorHandler(new IPublicationErrorHandler.ConsoleLogger())
                .setProperty(IBusConfiguration.Properties.BusId, "global bus"));
        return bus;
    }

    @Bean
    public ContextWrappedExecutorService asyncEventExecutorService() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(2);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(50);
        threadPoolTaskExecutor.setThreadNamePrefix("async-event-");
        threadPoolTaskExecutor.initialize();
        ContextWrappedExecutorService contextWrappedExecutorService = new ContextWrappedExecutorService(threadPoolTaskExecutor.getThreadPoolExecutor());
        return contextWrappedExecutorService;
    }

    @Bean
    public StringToUDCConverter stringToUDCConverter() {
        return new StringToUDCConverter();
    }

    /**
     * 自定义分页插件配置
     */
    @PostConstruct
    public void addPageInterceptor() throws Exception {
        PageableExecutorInterceptor interceptor = new PageableExecutorInterceptor();
//        OptimisticLocker optimisticLocker=new OptimisticLocker();
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
            sqlSessionFactory.getConfiguration().addInterceptor(interceptor);
            sqlSessionFactory.getConfiguration().setObjectFactory(new PageObjectFactory());
            sqlSessionFactory.getConfiguration().setObjectWrapperFactory(new PageObjectWrapperFactory());
            sqlSessionFactory.getConfiguration().setUseGeneratedKeys(true);
//            sqlSessionFactory.getConfiguration().addInterceptor(optimisticLocker);
            customConfig(sqlSessionFactory.getConfiguration());
        }
    }
    private void customConfig(	org.apache.ibatis.session.Configuration configuration) {
            BeanWrapperImpl wrapper = new BeanWrapperImpl(configuration);
        Map<String, String> settings= Maps.newHashMap();
        settings.put("mapUnderscoreToCamelCase", Boolean.TRUE.toString());
        settings.entrySet().stream()
                .forEach(entry -> wrapper.setPropertyValue(entry.getKey(), entry.getValue()));
        configuration.setObjectFactory(new PageObjectFactory());
        configuration.setObjectWrapperFactory(new PageObjectWrapperFactory());
        //处理insert之后返回id问题
        configuration.setUseGeneratedKeys(true);
    }

    @Bean
    public DateConverter dateConverter() {
        return new DateConverter();
    }


    @Bean
    public MeataApplicationReadyListener meataApplicationReadyListener(){
        return new MeataApplicationReadyListener();
    }


    @PostConstruct
    public void init() {
        ParserConfig.getGlobalInstance().getDeserializers().put(UDC.class, new UDCDeserializer());
    }
}
