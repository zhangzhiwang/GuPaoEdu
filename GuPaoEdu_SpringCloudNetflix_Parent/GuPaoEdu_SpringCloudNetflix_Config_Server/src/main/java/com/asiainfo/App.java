package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer	// 声明本工程是配置中心服务端
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}