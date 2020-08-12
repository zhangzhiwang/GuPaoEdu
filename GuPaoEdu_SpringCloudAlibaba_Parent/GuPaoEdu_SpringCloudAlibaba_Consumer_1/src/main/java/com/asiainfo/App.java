package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;

@SpringBootApplication
@EnableNacosDiscovery
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
