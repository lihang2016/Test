package com.example.springMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

/**
 * @Author lihang 【962309372@qq.com】
 * @Description:web配置
 * @Date 2017/10/29 16:07
 */
@Configuration
public class PageRequestConfig extends WebMvcConfigurerAdapter {
	/**
	 * 配置pageRequest
	 * @param argumentResolvers
	 */
    @Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
		argumentResolvers.add(new PageResquestConverter());
	}

	/**
	 * web 使用jackson
	 * @param converters
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		Iterator<HttpMessageConverter<?>> iterator = converters.iterator();
		while (iterator.hasNext()) {
			HttpMessageConverter<?> converter = iterator.next();
			if (converter.getClass().toString().endsWith("MappingJackson2HttpMessageConverter")) {
				MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter= (MappingJackson2HttpMessageConverter) converter;
				ObjectMapper objectMapper=mappingJackson2HttpMessageConverter.getObjectMapper();
				objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8")); //解决jackson 使用国际标准时间GMT进行格式化,导致和国内时区相差8小时的bug
			}
		}
		//	super.configureMessageConverters(converters);
	}
}
