package com.magadiflo.examenes.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EntityScan({ "com.magadiflo.commons.examenes.models.entity" })
@SpringBootApplication
public class FsMicroservicioExamenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsMicroservicioExamenesApplication.class, args);
	}

}
