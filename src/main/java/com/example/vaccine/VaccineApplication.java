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
				
				registry.addMapping("/org/signin").allowedOrigins("http://localhost:4200");
				registry.addMapping("/org/signin").allowCredentials(true);
				
				registry.addMapping("/org/signup").allowedOrigins("http://localhost:4200");
				registry.addMapping("/org/signup").allowCredentials(true);
				
				registry.addMapping("/vaccine/add").allowedOrigins("http://localhost:4200");
				registry.addMapping("/vaccine/add").allowCredentials(true);
				
				registry.addMapping("/org/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/org/*").allowCredentials(true);
				
				registry.addMapping("/patient/*/report").allowedOrigins("http://localhost:4200");
				registry.addMapping("/patient/*/report").allowCredentials(true);
				
				registry.addMapping("/vaccine/id/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/vaccine/id/*").allowCredentials(true);
			}
		};
	}
}
