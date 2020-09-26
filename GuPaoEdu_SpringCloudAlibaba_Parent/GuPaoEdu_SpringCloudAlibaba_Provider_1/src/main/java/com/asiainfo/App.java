package com.asiainfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;

@SpringBootApplication
@EnableNacosDiscovery // 开启nacos注册中心
@DubboComponentScan({ "com.asiainfo.service.impl" }) // 指定在哪里扫描标注了@DubboService注解的类，然后将其作为bean放入Spring的容器中
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		/**
		 * 1、Spring
		 * Cloud分为两大体系：一个是Netflix系列，一个是Alibaba系列，者两大系列都提供了对微服务的全套解决方案，每个体系都由若干组件组成，而且这两大体系之间的组件可以混用，但一般情况下不建议混用，如果选择某一体系则使用该体系提供的所有组件，某一体系各组件之间的兼容性是最好的。
		 * 2、dubbo是Spring Cloud Alibaba系列的组件之一。
		 * 3、生产者通过dubbo发布的服务消费者也必须通过dubbo来消费，通过netflex的eureka是消费不了的。
		 */

		// 借用一下GuPaoEdu_SpringCloudAlibaba_Provider_【1-3】三个工程测试一下基于Redis实现的分布式锁，此测试和SpringCloudAlibaba没有关系
		// 创建一个文件count.txt，里面的内容只有一个“0”，然后三个进程Provider_【1-3】分别去加1
//		InputStream inputStream = null;
//		OutputStream outputStream = null;
//		
//		Config config = new Config();
//		config.useSingleServer().setAddress("redis://localhost:6389");
//		RedissonClient redissonClient = Redisson.create(config);
//		RLock rLock = redissonClient.getLock("disLock");
//		
//		for (int i = 0; i < 1000; i++) {
//			rLock.lock();
//			try {
//				inputStream = new FileInputStream("/Users/zhangzhiwang/Desktop/count.txt");
//				byte[] bs = new byte[1024];
//				int len = 0;
//				int temp = 0;
//				while ((temp = inputStream.read()) != -1) {
//					bs[len] = (byte) temp;
//					len++;
//				}
//				Integer result = Integer.parseInt(new String(bs, 0, len));
//
//				String newValue = "" + (result + 1);
//				outputStream = new FileOutputStream("/Users/zhangzhiwang/Desktop/count.txt");
//				outputStream.write(newValue.getBytes());
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				if (inputStream != null) {
//					try {
//						inputStream.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//				if (outputStream != null) {
//					try {
//						outputStream.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//			rLock.unlock();
//		}
//		
//		redissonClient.shutdown();
	}
}
