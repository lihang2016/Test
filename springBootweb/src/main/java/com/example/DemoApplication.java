package com.example;

import com.example.config.ApplicationReadyListener;
import com.example.mpper.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.*.domain.repository", markerInterface = BaseMapper.class)
public class DemoApplication {

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
}
