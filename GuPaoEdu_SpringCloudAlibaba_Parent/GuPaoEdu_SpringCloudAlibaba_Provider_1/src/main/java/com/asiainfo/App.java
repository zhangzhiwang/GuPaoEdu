package com.asiainfo;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;

@SpringBootApplication
@EnableNacosDiscovery // 开启nacos注册中心
@DubboComponentScan({"com.asiainfo.service.impl"})// 指定在哪里扫描标注了@DubboService注解的类，然后将其作为bean放入Spring的容器中
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		/**
		 * 1、Spring Cloud分为两大体系：一个是Netflix系列，一个是Alibaba系列，者两大系列都提供了对微服务的全套解决方案，每个体系都由若干组件组成，而且这两大体系之间的组件可以混用，但一般情况下不建议混用，如果选择某一体系则使用该体系提供的所有组件，某一体系各组件之间的兼容性是最好的。
		 * 2、dubbo是Spring Cloud Alibaba系列的组件之一。
		 * 3、生产者通过dubbo发布的服务消费者也必须通过dubbo来消费，通过netflex的eureka是消费不了的。
		 */
	}
}
