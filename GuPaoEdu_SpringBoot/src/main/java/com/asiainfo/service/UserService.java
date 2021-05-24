package com.asiainfo.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import com.asiainfo.entity.Student;
import com.asiainfo.entity.User;

@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	private List<User> userList = new ArrayList<>();
	
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
	
	public void testOOM() {
//		List<User> userList = new ArrayList<>();
//		while(true) {
//			userList.add(new User());
//		}
//		testOOM();
//		while (true) {
//			Enhancer enhancer = new Enhancer();
//			enhancer.setSuperclass(OOM.class);
//			enhancer.setUseCache(false);
//			enhancer.setCallback(new MethodInterceptor() {
//				@Override
//				public Object intercept(Object obj, Method arg1, Object[] args, MethodProxy proxy) throws Throwable {
//					return proxy.invokeSuper(obj, args);
//				}
//			});
//			OOM oom = (OOM) enhancer.create();
//			oom.sayHello("Kevin LUAN");
//		}
	}
	
	static class OOM {
		public String sayHello(String str) {
			return "HI " + str;
		}
	}
}
