package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//Spring Boot uygulamasının başlatılmasını ve gerekli yapılandırmaların yapılmasını sağlar.
@SpringBootApplication
@EnableScheduling
@EnableWebSecurity
public class SpendingtrackingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpendingtrackingsystemApplication.class, args);
	}

}
