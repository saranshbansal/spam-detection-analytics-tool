package com.example.spamdetector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpamDetectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpamDetectorApplication.class, args);
	}
}
