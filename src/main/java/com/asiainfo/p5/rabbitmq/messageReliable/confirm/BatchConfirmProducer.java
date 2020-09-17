package com.asiainfo.p5.rabbitmq.messageReliable.confirm;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 消息确认模式之二——批量确认模式
 *
 * @author zhangzhiwang
 * @date Sep 16, 2020 10:37:27 PM
 */
public class BatchConfirmProducer {
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
		for(int i = 0; i < 10; i++) {
			channel.basicPublish("exchange_1", "key_zzw", null, "hello".getBytes());
		}
		channel.waitForConfirmsOrDie();// 等待本批次所有的消息都被broker确认接受了才可以，如果有其中任意一条没有收到broker的ack应答那么所有消息都不会发送成功。
		/**
		 * 批量确认模式的优缺点：批量确认模式解决了基本确认模式一条消息一确认的问题，但它也有缺点：那就是一个批次到底发送多少条消息合适，100条？1000条？10万条？
		 * 还有假如一个批次发送10000条消息，那么在发送最后一条消息之后没有收到broker的ack应答，那么前面的9999条消息也白发了（前面的9999条也不会发送到broker），需要将这1万条重新发送，这样的话会影响性能。
		 * 解决这个问题可以使用基于异步确认的模式
		 */
		
		channel.close();
		connection.close();
	}
}
