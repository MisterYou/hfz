package com.hfz.hfzadmin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@Configurable
@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
@EnableAutoConfiguration
public class HfzadminApplication {

	public static void main(String[] args) {
		SpringApplication.run(HfzadminApplication.class, args);
	}
}
