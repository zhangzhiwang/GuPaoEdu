package com.asiainfo.p5.rabbitmq.flowControl;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
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
public class FlowControlProvider {
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		connectionFactory.setVirtualHost("new_vhost_4");

		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.exchangeDeclare("exchange_4", "direct", false, false, null);
		channel.queueDeclare("queue_4", false, false, false, null);
		channel.queueBind("queue_4", "exchange_4", "key_4");
		for(int i = 0; i < 1000; i++) {
			Thread.sleep(300);
			channel.basicPublish("exchange_4", "key_4", null, "FlowControlTest".getBytes());
			System.out.println(i);
		}
	}
}
