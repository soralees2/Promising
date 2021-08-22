package com.promising;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication
@PropertySource("classpath:/application-dev.properties")
public class PromisingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromisingApplication.class, args);
	}

}
