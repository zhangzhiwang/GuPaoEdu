package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 声明本工程是eureka的客户端
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
