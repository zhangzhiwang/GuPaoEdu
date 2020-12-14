package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard// 开启hystrix监控面板
@EnableCircuitBreaker
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
