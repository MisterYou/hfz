package com.hfz.hfzturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class HfzTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(HfzTurbineApplication.class, args);
	}
}
