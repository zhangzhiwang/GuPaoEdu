package com.asiainfo.p5.rabbitmq.messageReliable.returnlistener;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ReturnListener;
import com.rabbitmq.client.AMQP.BasicProperties;

/**
 * 解决交换机无法将消息转发到指定队列的方式一——消息回发，即消息由交换机回发给producer
 *
 * @author zhangzhiwang
 * @date Sep 16, 2020 11:33:56 PM
 */
public class ReturnListenerProducer {
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("127.0.0.1");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		connectionFactory.setVirtualHost("/");

		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare("exchange_2", "direct", false, false, null);
//		channel.queueDeclare("queue_1", false, false, false, null);
//		channel.queueBind("queue_1", "exchange_1", "key_zzw");

		channel.addReturnListener(new ReturnListener() {
			@Override
			public void handleReturn(int arg0, String arg1, String arg2, String arg3, BasicProperties arg4, byte[] arg5)
					throws IOException {// 当交换机将消息退回给producer的时候会回调此方法
				System.out.println("消息被回退 ：" + new String(arg5));
			}
		});

		channel.basicPublish("exchange_2", "key_zzw", true, // 第三个参数mandatory如果设置为true，则消息无法转发时会被退回给producer，如果为false则会丢弃无法转发的消息
				null, "return message".getBytes());// 由于exchange_2没有绑定任何队列，所以发送到exchange_2的消息会被退回

		Thread.sleep(1000);// 消息被交换机退回之前要保证producer不能结束运行
		
		channel.close();
		connection.close();
	}
}
