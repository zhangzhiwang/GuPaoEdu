package com.asiainfo.p5.rabbitmq.messageReliable.confirm;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 消息确认模式之一——基本的确认模式
 *
 * @author zhangzhiwang
 * @date Sep 16, 2020 10:37:27 PM
 */
public class BasicConfirmProducer {
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("127.0.0.1");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		connectionFactory.setVirtualHost("/");

		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare("exchange_1", "direct", false, false, null);
		channel.queueDeclare("queue_1", false, false, false, null);
		channel.queueBind("queue_1", "exchange_1", "key_zzw");

		channel.confirmSelect();// 开启消息确认模式
		channel.basicPublish("exchange_1", "key_zzw", null, "hello".getBytes());
		/**
		 *  根据方法名或者官方的注释或者根据该方法抛出InterruptedException可以知道waitForConfirms是一个阻塞方法，直到收到broker的应答为止。
		 *  所以基本的确认模式的缺点是：由于是阻塞的所以肯定影响效率，另外确认模式也有producer和broker之间的指令交互，一条消息一确认也影响效率
		 */
		if(channel.waitForConfirms()) {// 如果返回true说明收到了broker的接收确认应答
			System.out.println("收到broker应答ack");
		} else {
			System.out.println("未收到broker应答ack");
		}
		
		
		channel.close();
		connection.close();
	}
}
