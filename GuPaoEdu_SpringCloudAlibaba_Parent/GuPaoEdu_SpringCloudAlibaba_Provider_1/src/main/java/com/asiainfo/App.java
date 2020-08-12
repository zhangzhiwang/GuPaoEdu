package com.asiainfo;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;

@SpringBootApplication
@EnableNacosDiscovery // 开启nacos注册中心
@DubboComponentScan({"com.asiainfo.service.impl"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
