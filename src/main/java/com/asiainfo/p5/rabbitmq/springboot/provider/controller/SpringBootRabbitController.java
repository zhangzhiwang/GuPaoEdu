package com.asiainfo.p5.rabbitmq.springboot.provider.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.p5.rabbitmq.springboot.User;

@RestController
public class SpringBootRabbitController {
	@Autowired
	AmqpTemplate amqpTemplate;
	
	@GetMapping("/push")
	public void push() {
		amqpTemplate.convertAndSend("firstExchange", "zzw", "This is direct msg.");
		amqpTemplate.convertAndSend("secondExchange", "c.a.zzw.b", "This is topic msg.");
		amqpTemplate.convertAndSend("thirdExchange", "", "This is fanout msg.");
		
//		User user = new User();
//		user.setAge(10);
//		user.setName("zs");
//		amqpTemplate.convertAndSend("firstExchange", "zzw", user);
	}
}
