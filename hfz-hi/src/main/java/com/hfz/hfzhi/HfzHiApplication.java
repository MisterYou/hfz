package com.hfz.hfzhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableEurekaClient
@RefreshScope
public class HfzHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HfzHiApplication.class, args);
	}



}
