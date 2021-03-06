package com.asiainfo.p5.rabbitmq.flowControl;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * rabbitmq流量控制 控制方式： 1、rabbitmq服务端控制
 * 在服务端，通过队列的x-max-length参数和x-max-length-bytes参数可以控制服务端保存消息的数量。
 * 但是：如果消息的总数量或者总大小达到了这两个阈值，那么再有新消息到来的时候rabbitmq回替换掉队列里面最老的消息然后把新消息纳入进来，并不能达到拒绝接收新消息的效果。
 * 如果想达到拒绝新消息的效果，可以： （1）内存控制 内存控制设置的是已使用内存的百分比或一个绝对值，当达到这个阈值以后服务端拒绝接收新消息。
 * （2）磁盘控制 磁盘控制设置的是未使用（空闲）磁盘的百分比或一个绝对值，当达到这个阈值以后服务端拒绝接收新消息。
 * （内存控制和磁盘空值都可以通过rabbitmqctl命令或者在修改配置文件来设置，前者可已在broker运行时动态修改并生效，但是下次启动会失效，后者永久生效。但是在实际的测试中值进行了rabbitmqctl命令的测试，配置文件网上搜了好多资源不知道到底修改哪个配置文件以及在Mac上配置文件在哪里。）
 * 2、消费者控制 详见FlowControlConsumer.java
 *
 * @author zhangzhiwang
 * @date Sep 2, 2020 11:47:13 AM
 */
public class FlowControlConsumer {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		connectionFactory.setVirtualHost("new_vhost_4");

		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				System.out.println("body = " + new String(body));
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// 如果将autoAck设置为false，则必须进行手工应答
				channel.basicAck(envelope.getDeliveryTag(), true);
			}
		};
		// 消费者限流要调用basicQos方法，同时要配合着将autoAck设置为false。该方法的意思是消费者在消费了多少条消息之后仍然没有给服务端发送ack应答，那么服务端就不会发送消息了
		// 消费者消费消息（basicConsume）和处理消息（handleDelivery）是在不同的线程来进行的，如果处理速度跟不上接收速度的话那么就要在消费端控制流量，basicQos方法可以理解为能够缓存消息的数量，超过这个数量服务端就不会发送消息了（不会抛异常）直到没有处理的消息数量降到了这个值以下，这个时候会继续投递消息
		channel.basicQos(2);
		channel.basicConsume("queue_4", 
				false,// autoAck，是否自动应答，默认情况下是true。默认情况下消费者一接收到服务端的消息就立即返回一个ack应答，代表已经接收了该条消息，服务端接收到ack应答后继续投递下一条消息。
					 // 如果需要手动应答，改值设置为false，如果设置为false，那么必须在handleDelivery方法进行手动应答
				consumer);
	}
}
