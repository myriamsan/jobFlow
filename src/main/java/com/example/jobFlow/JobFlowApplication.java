package com.example.jobFlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.paulschwarz.springdotenv.spring.DotenvApplicationInitializer;

@SpringBootApplication
public class JobFlowApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(JobFlowApplication.class);
		app.addInitializers(new DotenvApplicationInitializer());
		app.run(args);
	}

}
