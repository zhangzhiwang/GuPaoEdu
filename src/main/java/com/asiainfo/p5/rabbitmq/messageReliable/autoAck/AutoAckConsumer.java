package com.asiainfo.p5.rabbitmq.messageReliable.autoAck;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 解决消息可靠性问题4——自动或手动应答
 *
 * @author zhangzhiwang
 * @date Sep 17, 2020 12:51:37 PM
 */
public class AutoAckConsumer {
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("127.0.0.1");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		connectionFactory.setVirtualHost("/");

		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();

		channel.basicConsume("queue_1", true,// autoAck自动应答broker，注意自动应答是consumer一接收到消息（此时消息还没有处理）就立即给broker发送ack应答。
											 // 这样带来的一个弊端就是如果应答后消息处理失败了需要重新消费，但是broker已经收到了确认消息把这条消息从队列移除了。解决这个问题可以使用手动应答的方式。
											 // 手动应答要将autoAck设置为false，并在回调的handleDelivery方法里进行手动应答。
				new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String msg = new String(body);
				System.out.println(msg);
				System.out.println("deliveryTag = " + envelope.getDeliveryTag());
				if(msg.contains("拒绝")) {
					channel.basicReject(envelope.getDeliveryTag(), 
							false// 是否重回队列
							);
					System.out.println("已拒绝");
					return;
				}
				
				try {
					System.out.println("进行业务处理");
					int i = 1 / 0;
					channel.basicAck(envelope.getDeliveryTag(), false);
					return;
				} catch (Exception e) {
					e.printStackTrace();
					// 消息处理异常要发送nack
					channel.basicNack(envelope.getDeliveryTag(), false, true);
				}
			}
		});
	}
}
