package com.asiainfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.util.RedisUtil;

@SpringBootApplication
@RestController
public class App {
//	@Autowired// @Autowired和@Resource不能作用在静态域上面。@Resource作用在静态域上面运行报错，@Autowired作用在静态域上面运行不会报错但注入的对象是null
//	private static RedisTemplate<String, String> redisTemplate;
	@Autowired
	private RedisUtil redisUtil;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@GetMapping("/test")
	public void test() {	
		redisUtil.set("test", "11123");
		String result = redisUtil.get("");
		System.out.println(result);
	}
}
