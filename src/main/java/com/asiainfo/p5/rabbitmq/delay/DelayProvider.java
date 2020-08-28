package com.asiainfo.p5.rabbitmq.delay;

import java.util.HashMap;
import java.util.Map;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 测试延时队列
 *
 * @author zhangzhiwang
 * @date Aug 28, 2020 1:33:00 PM
 */
public class DelayProvider {
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("127.0.0.1");
		connectionFactory.setPort(5672);
		connectionFactory.setVirtualHost("new_vhost_3");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		
		Map<String, Object> arguments = new HashMap<String, Object>();
		arguments.put("x-delayed-type", "direct");
		channel.exchangeDeclare("delay_exchange_zzw", "x-delayed-message",// 注意只有安装了rabbitmq_delayed_message_exchange插件并且启动之后才能使用延时队列，延时交换机的类型是x-delayed-message
				false, false, arguments);
		
		channel.queueDeclareNoWait("delay_queue_zzw", false, false, false, null);
		channel.queueBind("delay_queue_zzw", "delay_exchange_zzw", "delay_key");
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("x-delay", 10000);// 设置延迟时间，单位ms
		AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().headers(headers).build();
		
		String msg = "delay_msg";
		channel.basicPublish("delay_exchange_zzw", "delay_key", properties, msg.getBytes());
		
		channel.close();
		connection.close();
	}
}
