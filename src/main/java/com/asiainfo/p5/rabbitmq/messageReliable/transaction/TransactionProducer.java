package com.asiainfo.p5.rabbitmq.messageReliable.transaction;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * rabbitmq的消息可靠性保障主要体现在四个地方（有四个地方可能会出现消息可靠性问题）：
 * 1、producer发出了消息但是rabbitmq的broker没有接收到
 * 2、exchange没有吧消息成功路由到指定的队列里面
 * 3、队列是实际存储消息的地方，如果队列出现问题那么消息就丢失了
 * 4、consumer在从queue取数据的之后没有给rabbitmq发送ack消息，这里可能会出现消息丢失
 * 
 * 面对第一个问题有两种解决方案：
 * 1、producer开启事务模式
 * 2、producer开启消息确认模式
 * 	 消息确认模式又分为三种：
 * 	 （1）基本确认模式
 *   （2）批量确认模式
 *   （3）异步确认模式
 *
 * @author zhangzhiwang
 * @date Sep 16, 2020 10:11:31 PM
 */
public class TransactionProducer {// 事务模式
	public static void main(String[] args) throws IOException, TimeoutException {
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
		
		try {
			// 事务模式的缺点：每发送一个消息就要开启和提交事务，并且事务模式中producer发起事务和收到broker的应答之间会有多个指令交互，影响性能
			channel.txSelect();// 开启事务模式
			channel.basicPublish("exchange_1", "key_zzw", null, "拒绝".getBytes());
//			int i = 1 / 0;
			channel.txCommit();// 事务提交，开启事务模式后要手动提交
		} catch (Exception e) {
			e.printStackTrace();
			channel.txRollback();// 如果提交失败（比如提交后没有收到broker的应答信息）会抛出异常，这时要回滚
		}
		
		
		channel.close();
		connection.close();
	}
}
