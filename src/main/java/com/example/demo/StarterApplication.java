package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class StarterApplication {

//	@Value("${login.recaptcha.flag}")
//	private String demo;

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
//		SpringApplication app = new SpringApplication(StarterApplication.class);
//		ConfigurableApplicationContext context = app.run(args);
//		String myProperty = context.getEnvironment().getProperty("login.recaptcha.flag");
//		System.out.println("my.property = " + myProperty);
	}

//	@PostConstruct
//	public void init() {
//		System.out.println("Demo ki value : " + demo);
//	}

}
