package com.example;

import com.example.config.ApplicationReadyListener;
import com.example.springMvc.PageResquestConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = "com.example.*.domain.repository")
public class DemoApplication  extends WebMvcConfigurerAdapter {

	//第一种方式
	@Value("${book.author}")
	private String name;

	@Value("${book.name}")
	private String bookName;


	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(DemoApplication.class);
		springApplication.addListeners(new ApplicationReadyListener());
		springApplication.run(DemoApplication.class, args);
	}
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
		argumentResolvers.add(new PageResquestConverter());
	}
}
