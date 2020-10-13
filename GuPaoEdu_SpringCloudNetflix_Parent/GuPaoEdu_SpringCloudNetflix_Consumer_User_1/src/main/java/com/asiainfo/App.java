package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient // 声明本工程是eureka的客户端
@EnableFeignClients(basePackages = {
		"com.asiainfo.service.interfaceTest"// GuPaoEdu_SpringCloudNetflix_Provider_User_Api.jar里面的路径
		})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
