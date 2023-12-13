package com.msecurity04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Msecurity04Application {

	public static void main(String[] args) {
		SpringApplication.run(Msecurity04Application.class, args);
	}

}
