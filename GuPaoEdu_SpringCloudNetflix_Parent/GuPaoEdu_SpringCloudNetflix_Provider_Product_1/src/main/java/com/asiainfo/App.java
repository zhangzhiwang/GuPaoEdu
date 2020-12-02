package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient // 声明本工程作为eureka的客户端，服务的生产者和消费者都是eureka的客户端
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
