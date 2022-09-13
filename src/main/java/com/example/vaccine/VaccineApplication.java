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
				registry.addMapping("/patient/signin").allowedOrigins("http://localhost:4201");
				registry.addMapping("/patient/signin").allowCredentials(true);
				
				registry.addMapping("/patient/signup").allowedOrigins("http://localhost:4201");
				registry.addMapping("/patient/signup").allowCredentials(true);
				
				registry.addMapping("/patient/update").allowedOrigins("http://localhost:4201");
				registry.addMapping("/patient/update").allowCredentials(true);
				
				registry.addMapping("/org/signin").allowedOrigins("http://localhost:4201");
				registry.addMapping("/org/signin").allowCredentials(true);
				
				registry.addMapping("/org/signup").allowedOrigins("http://localhost:4201");
				registry.addMapping("/org/signup").allowCredentials(true);
				
				registry.addMapping("/vaccine/add").allowedOrigins("http://localhost:4201");
				registry.addMapping("/vaccine/add").allowCredentials(true);
				
				registry.addMapping("/org/*/vaccines").allowedOrigins("http://localhost:4201");
				registry.addMapping("/org/*/vaccines").allowCredentials(true);
				
				registry.addMapping("/org/*").allowedOrigins("http://localhost:4201");
				registry.addMapping("/org/*").allowCredentials(true);
				
				registry.addMapping("/patient/*/report").allowedOrigins("http://localhost:4201");
				registry.addMapping("/patient/*/report").allowCredentials(true);
				
				registry.addMapping("/vaccine/id/*").allowedOrigins("http://localhost:4201");
				registry.addMapping("/vaccine/id/*").allowCredentials(true);
				
				registry.addMapping("/partners").allowedOrigins("http://localhost:4201");
				registry.addMapping("/partners").allowCredentials(true);
				
				registry.addMapping("/vaccines").allowedOrigins("http://localhost:4201");
				registry.addMapping("/vaccines").allowCredentials(true);
				
				registry.addMapping("/org/update").allowedOrigins("http://localhost:4201");
				registry.addMapping("/org/update").allowCredentials(true);
				
				registry.addMapping("/org/delete/*").allowedOrigins("http://localhost:4201");
				registry.addMapping("/org/delete/*").allowCredentials(true);
				
				registry.addMapping("/org/*/vaccines").allowedOrigins("http://localhost:4201");
				registry.addMapping("/org/*/vaccines").allowCredentials(true);
				
				registry.addMapping("/vaccine/update").allowedOrigins("http://localhost:4201");
				registry.addMapping("/vaccine/update").allowCredentials(true);
				
				registry.addMapping("/vaccine/delete/*").allowedOrigins("http://localhost:4201");
				registry.addMapping("/vaccine/delete/*").allowCredentials(true);
				
				registry.addMapping("/unenrolledpatients").allowedOrigins("http://localhost:4201");
				registry.addMapping("/unenrolledpatients").allowCredentials(true);
				
				registry.addMapping("/patient/delete/*").allowedOrigins("http://localhost:4201");
				registry.addMapping("/patient/delete/*").allowCredentials(true);
				
				registry.addMapping("/report/add").allowedOrigins("http://localhost:4201");
				registry.addMapping("/report/add").allowCredentials(true);
				
				registry.addMapping("/report/update").allowedOrigins("http://localhost:4201");
				registry.addMapping("/report/update").allowCredentials(true);
				
				registry.addMapping("/report/delete/*").allowedOrigins("http://localhost:4201");
				registry.addMapping("/report/delete/*").allowCredentials(true);
				
				registry.addMapping("/report/*").allowedOrigins("http://localhost:4201");
				registry.addMapping("/report/*").allowCredentials(true);
				
				registry.addMapping("/vaccine/disease/*").allowedOrigins("http://localhost:4201");
				registry.addMapping("/vaccine/disease/*").allowCredentials(true);
				
				registry.addMapping("/distinct/disease").allowedOrigins("http://localhost:4201");
				registry.addMapping("/distinct/disease").allowCredentials(true);
				
				registry.addMapping("/unenrolledpatients/*").allowedOrigins("http://localhost:4201");
				registry.addMapping("/unenrolledpatients/*").allowCredentials(true);
				
				registry.addMapping("/patient/*").allowedOrigins("http://localhost:4201");
				registry.addMapping("/patient/*").allowCredentials(true);
				
				registry.addMapping("/report/vaccine/*").allowedOrigins("http://localhost:4201");
				registry.addMapping("/report/vaccine/*").allowCredentials(true);
				registry.addMapping("/org/{id}/patients").allowedOrigins("http://localhost:4201");
				registry.addMapping("/org/{id}/patients").allowCredentials(true);
			}
		};
	}
}
