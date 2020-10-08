package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 标明该工程是eureka服务端
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
