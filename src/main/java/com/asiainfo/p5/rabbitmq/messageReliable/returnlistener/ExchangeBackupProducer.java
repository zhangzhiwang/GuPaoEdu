package com.asiainfo.p5.rabbitmq.messageReliable.returnlistener;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ReturnListener;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties;

/**
 * 解决交换机无法将消息转发到指定队列的方式二——交换机备份，当交换机无法路由消息时会讲该消息转发给备份交换机（注意：备份交换机是专门处理不能被路由的消息的），备份交换机可以绑定队列，从而被响应消费者消费
 *
 * @author zhangzhiwang
 * @date Sep 16, 2020 11:33:56 PM
 */
public class ExchangeBackupProducer {
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("127.0.0.1");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		connectionFactory.setVirtualHost("/");

		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		
		// 模拟过程：producer将消息发送给exchange_3，但是由于exchange_3没有绑定任何队列，所以消息路由失败，这时exchange_3将该消息发送给备份交换机exchange_bak，而exchange_bak绑定了队列，从而可以被消费者消费
		channel.exchangeDeclare("exchange_bak", "direct", false, false, null);// 声明备份交换机
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("alternate-exchange", "exchange_bak");
		channel.exchangeDeclare("exchange_3", "direct", false, false, arguments);// exchange_bak是exchange_3的备份交换机
		channel.queueDeclare("queue_bak", false, false, false, null);
		channel.queueBind("queue_bak", "exchange_bak", "key_zzw");// 备份交换机绑定队列

		channel.basicPublish("exchange_3", "key_zzw", false, // 第三个参数mandatory如果设置为true，则消息无法转发时会被退回给producer，如果为false则会丢弃无法转发的消息
				null, "return message".getBytes());// 由于exchange_2没有绑定任何队列，所以发送到exchange_2的消息会被退回

		channel.close();
		connection.close();
	}
}
