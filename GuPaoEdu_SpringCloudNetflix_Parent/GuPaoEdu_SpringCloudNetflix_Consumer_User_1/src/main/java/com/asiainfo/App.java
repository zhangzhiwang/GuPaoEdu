package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableEurekaClient // 声明本工程是eureka的客户端
@EnableFeignClients(basePackages = {
		"com.asiainfo.service.interfaceTest"// GuPaoEdu_SpringCloudNetflix_Provider_User_Api.jar里面的路径
		})// @EnableFeignClients扫描标注了@FeignClient注解的类，将其注册为bean，如果被扫描的类不在默认路径下需要使用basePackages指定扫描路径
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
