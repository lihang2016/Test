package com.example;

import com.example.Annto.Boot;
import com.example.config.ApplicationReadyListener;
import org.springframework.boot.SpringApplication;

@Boot
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(DemoApplication.class);
		springApplication.addListeners(new ApplicationReadyListener());
		springApplication.run(DemoApplication.class, args);
	}

}
