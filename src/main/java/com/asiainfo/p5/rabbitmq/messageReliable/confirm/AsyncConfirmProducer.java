package com.asiainfo.p5.rabbitmq.messageReliable.confirm;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 消息确认模式之三——异步确认模式
 *
 * @author zhangzhiwang
 * @date Sep 16, 2020 10:37:27 PM
 */
public class AsyncConfirmProducer {
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
		
		final SortedSet<Long> sortedSet = Collections.synchronizedSortedSet(new TreeSet<Long>());
		channel.addConfirmListener(new ConfirmListener() {
			
			/**
			 * 处理发生异常的消息
			 */
			@Override
			public void handleNack(long deliveryTag, boolean multiple) throws IOException {//deliveryTag从1开始
				System.out.println("++++++++Broker未确认消息，标识：" + deliveryTag);
				if(multiple) {
					sortedSet.headSet(deliveryTag + 1).clear();
				} else {
					sortedSet.remove(deliveryTag);
				}
			}
			
			/**
			 * 处理成功的消息
			 */
			@Override
			public void handleAck(long deliveryTag, boolean multiple) throws IOException {
				System.out.println("	Broker确认消息，标识：" + deliveryTag);
				if(multiple) {
					sortedSet.headSet(deliveryTag + 1).clear();
				} else {
					sortedSet.remove(deliveryTag);
				}
				System.out.println("未确认的消息:"+sortedSet);
			}
		});
		
		
		channel.confirmSelect();// 开启消息确认模式
		for(int i = 0; i < 10; i++) {
			long nextPublishSeqNo = channel.getNextPublishSeqNo();
			System.out.println("下一条即将发送：" + nextPublishSeqNo);
			channel.basicPublish("exchange_1", "key_zzw", null, "hello".getBytes());
			sortedSet.add(nextPublishSeqNo);
		}
		System.out.println("所有消息:"+sortedSet);
//		channel.close();
//		connection.close();
	}
}
