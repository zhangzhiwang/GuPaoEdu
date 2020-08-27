package com.asiainfo.p5.rabbitmq.deadLeter;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 死信交换机和死信队列
 *
 * @author zhangzhiwang
 * @date Aug 27, 2020 7:25:37 PM
 */
public class DeadLetterConsumer {
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("127.0.0.1");
		connectionFactory.setPort(5672);// 注意浏览器访问控制平台的端口默认是是15672，代码连接rabbitmq的端口默认是5672
		connectionFactory.setVirtualHost("new_vhost_2");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");

		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();

//		channel.basicConsume("normal_queue", new DefaultConsumer(channel) {
//			@Override
//			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
//					byte[] body) throws IOException {
//				System.out.println("envelope = " + envelope);
//				System.out.println("receive msg = " + new String(body));
//			}
//		});
		
		channel.basicReject(2, false);// 使消息成为死信情况3，但模拟失败（拒收后没有重新放回队列，单并没有放到死信队列里面）
	}
}
