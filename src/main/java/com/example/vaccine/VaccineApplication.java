package com.example.vaccine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class VaccineApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccineApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/patient/signin").allowedOrigins("http://localhost:4200");
				registry.addMapping("/patient/signin").allowCredentials(true);
				
				registry.addMapping("/patient/signup").allowedOrigins("http://localhost:4200");
				registry.addMapping("/patient/signup").allowCredentials(true);
				
				registry.addMapping("/patient/update").allowedOrigins("http://localhost:4200");
				registry.addMapping("/patient/update").allowCredentials(true);
			}
		};
	}
}
