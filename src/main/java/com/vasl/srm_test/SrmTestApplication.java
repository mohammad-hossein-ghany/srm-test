package com.vasl.srm_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.client.RestTemplate;

@EnableMongoAuditing
@SpringBootApplication
public class SrmTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrmTestApplication.class, args);
	}

}




