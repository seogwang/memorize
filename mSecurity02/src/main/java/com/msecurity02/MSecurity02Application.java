package com.msecurity02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MSecurity02Application {

	public static void main(String[] args) {
		SpringApplication.run(MSecurity02Application.class, args);
	}

}
