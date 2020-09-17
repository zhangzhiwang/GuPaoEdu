package com.asiainfo.p5.rabbitmq.messageReliable.durable;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.boot.autoconfigure.jms.JmsProperties.DeliveryMode;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 解决消息可靠性问题3（存储消息的队列出问题）的措施——持久化
 *
 * @author zhangzhiwang
 * @date Sep 17, 2020 12:08:36 AM
 */
public class DurableProducer {
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("127.0.0.1");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		connectionFactory.setVirtualHost("/");

		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare("exchange_4", "direct", true,// 如果将durable属性设置为false，那么交换机、队列的元信息是保存在内存里面的，为了防止宕机或者服务挂掉的情况最好要保存在磁盘上
				false, null);
		channel.queueDeclare("queue_4", true,// 持久化
				false, false, null);
		channel.queueBind("queue_4", "exchange_4", "key_zzw");

		// 光交换机和队列的元信息持久化还不够，消息本身也要持久化
		AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder().deliveryMode(DeliveryMode.NON_PERSISTENT.getValue()).
                contentEncoding("UTF-8").build();
		channel.basicPublish("exchange_4", "key_zzw", properties, "durable message".getBytes());

		channel.close();
		connection.close();
	}
}
