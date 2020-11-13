package com.asiainfo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import com.asiainfo.controller.TestController;
import com.asiainfo.entity.Student;

@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	public void testService1() {
		LOGGER.debug("	service debug");
		LOGGER.info("	service info");
		LOGGER.error("	service error");
	}
	
	public void testService2() {
		String s = null;
		s.length();
	}
	
	public void test3() {
//		redisTemplate.opsForValue().set("k1", "111");// value使用StringRedisSerializer
		
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Student.class));
		Student student = new Student(1, "张三", 18);
		redisTemplate.opsForValue().set("student", student);// value使用JdkSerializationRedisSerializer
		
		Object obj = redisTemplate.opsForValue().get("student");
		System.out.println("obj.class : " + obj.getClass());
		System.out.println("instanceof : " + (obj instanceof Student));
	}
}
