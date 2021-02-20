package com.rippleofknowledge.leitnerbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class LeitnerBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeitnerBoxApplication.class, args);
	}

}
