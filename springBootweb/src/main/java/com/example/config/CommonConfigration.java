
package com.example.config;

import ch.qos.logback.classic.pattern.DateConverter;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.common.udc.StringToUDCConverter;
import com.example.common.udc.UDC;
import com.example.common.udc.UDCDeserializer;
import com.example.mybatisMapper.pages.PageObjectFactory;
import com.example.mybatisMapper.pages.PageObjectWrapperFactory;
import com.example.mybatisMapper.pages.PageableExecutorInterceptor;
import com.example.scaneum.listener.MeataApplicationReadyListener;
import com.example.springMvc.CustomSortHandlerMethodArgumentResolver;
import com.example.springMvc.PageResquestConverter;
import com.example.util.event.EventBus;
import com.example.util.event.EventHandler;
import com.google.common.base.Splitter;
import net.engio.mbassy.bus.config.BusConfiguration;
import net.engio.mbassy.bus.config.Feature;
import net.engio.mbassy.bus.config.IBusConfiguration;
import net.engio.mbassy.bus.error.IPublicationErrorHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.support.PagedListHolder.DEFAULT_PAGE_SIZE;

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
        }
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
