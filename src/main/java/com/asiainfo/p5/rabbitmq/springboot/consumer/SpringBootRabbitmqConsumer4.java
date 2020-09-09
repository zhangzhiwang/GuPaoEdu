package com.asiainfo.p5.rabbitmq.springboot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"forthQueue"})// 该消费者监听哪些队列
public class SpringBootRabbitmqConsumer4 {
	@RabbitHandler// 在rabbitmq和spring（非Spring Boot）整合的时候，消费者类需要实现MessageListener接口，并重写onMessage方法，该方法用于接收到消息后回调。
	       		  // 而rabbitmq和spring boot整合后需要在消费者类上田间监听器注解@RabbitListener，以表明消费者监听哪些队列，并且在自定义的方法上加上注解@RabbitHandler用于接收消息后的回调
				  // 该自定义方法接可以接收任何类型的参数，如果是对象类型则要加@Payload注解
	public void getMsg(String msg) {
		System.out.println("Consumer4 : " + msg);
	}
}
