package com.asiainfo.p5.rabbitmq.delay;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 测试延时队列
 *
 * @author zhangzhiwang
 * @date Aug 28, 2020 1:33:00 PM
 */
public class DelayConsumer {
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("127.0.0.1");
		connectionFactory.setPort(5672);
		connectionFactory.setVirtualHost("new_vhost_3");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");

		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();

		channel.basicConsume("delay_queue_zzw", new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				System.out.println(new String(body));
			}
		});
	}
}
