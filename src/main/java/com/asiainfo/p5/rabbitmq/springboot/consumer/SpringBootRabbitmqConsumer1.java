package com.asiainfo.p5.rabbitmq.springboot.consumer;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.asiainfo.p5.rabbitmq.springboot.User;
import com.rabbitmq.client.Channel;

@Component
@RabbitListener(queues = {"firstQueue"},// 该消费者监听哪些队列
	containerFactory = "rabbitListenerContainerFactory" // 如果需要特殊处理时（比如自定义序列化和反序列化或者设置手动应答等）要加上containerFactory属性，值为配置类中SimpleRabbitListenerContainerFactory对象
														// 如果没有自定义配置，则可以不加containerFactory属性
		)// 该消费者监听哪些队列
public class SpringBootRabbitmqConsumer1 {
//	@RabbitHandler// 在rabbitmq和spring（非Spring Boot）整合的时候，消费者类需要实现MessageListener接口，并重写onMessage方法，该方法用于接收到消息后回调。
//	       		  // 而rabbitmq和spring boot整合后需要在消费者类上田间监听器注解@RabbitListener，以表明消费者监听哪些队列，并且在自定义的方法上加上注解@RabbitHandler用于接收消息后的回调
//	public void getMsg(String msg) {
//		System.out.println("Consumer1 : " + msg);
//	}
	
//	@RabbitHandler// 该自定义方法接可以接收任何类型的参数，如果是对象类型则要加@Payload注解
//	public void getMsg(@Payload User user) {
//		System.out.println("Consumer1 user: " + user.getName());
//	}
	
	@RabbitHandler
	public void getMsg(String msg, Channel channel, Message message) {// 需要手动应答时入參要加上Channel和Message
		System.out.println("Consumer1 : " + msg);
		
		try {
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
