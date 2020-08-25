package com.asiainfo.p5.rabbitmq;

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
 * rabbitmq生产者
 *
 * @author zhangzhiwang
 * @date Aug 25, 2020 12:32:26 PM
 */
public class RabbitMqProvider {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");// 设置rabbitmq服务器的ip和端口
		connectionFactory.setPort(5672);
		connectionFactory.setVirtualHost("/");// 设置虚拟主机（VHost）地址，默认的VHost就是“/”。每一个exchange都归属于一个VHost，VHost起到对exchange的隔离作用，使不同VHost下的exchange互相不受影响，类似Java中的package
		connectionFactory.setUsername("guest");// rabbitmq默认的用户名和密码是guest
		connectionFactory.setPassword("guest");

		// 用ConnectionFactory创建Connection，Connection是一个长链接，Connection里面又划分了许多信道
		Connection connection = connectionFactory.newConnection();
		// 用Connection创建信道Channel
		Channel channel = connection.createChannel();
		// ****************以上连接rabbitmq的内容和消费者是一样*****************

		String msg = "Hello World!";// 待发送的消息
		// 用Channel来发送消息，生产者发送消息和消费者接受消息都是通过Channel来进行的
		channel.basicPublish("exchange_1", // 要发送的交换机
				"zzw_rabbitmq_test", // 路由键，由于创建的交换机类型是直连，所以routingKey必须和bindingKey一致
				// 路由键（routingKey）和绑定建（bindingKey）的关系要看交换机的类型，如果交换机的类型是直连，那么routingKey必须严格和bindingKey一致；如果交换机的类型是topic，那么bindingKey可以使用通配符；如果交换机的类型是fanout（广播），那么不需要routingKey和bindingKey
				null, // BasicProperties，消息的其他属性，比如过期时间等
				msg.getBytes());
		
		// 发送完消息要将信道关闭掉，注意关闭信道不是关闭长连接，长连接是Connection
		channel.close();
		// 关闭Connection，最后在不需要长连接的时候将Connection关闭掉
		connection.close();
	}
}
