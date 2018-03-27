package com.hfz.hfzzipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class HfzZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HfzZipkinServerApplication.class, args);
	}
}
