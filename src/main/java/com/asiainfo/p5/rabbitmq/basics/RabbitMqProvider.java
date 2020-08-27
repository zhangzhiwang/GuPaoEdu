package com.asiainfo.p5.rabbitmq.basics;

import java.util.HashMap;
import java.util.Map;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * rabbitmq生产者
 *
 * @author zhangzhiwang
 * @date Aug 25, 2020 12:32:26 PM
 */
public class RabbitMqProvider {
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");// 设置rabbitmq服务器的ip和端口
		connectionFactory.setPort(5672);
		connectionFactory.setVirtualHost("new_vhost");// 设置虚拟主机（VHost）地址，默认的VHost就是“/”。每一个exchange都归属于一个VHost，VHost起到对exchange的隔离作用，使不同VHost下的exchange互相不受影响，类似Java中的package
		connectionFactory.setUsername("guest");// rabbitmq默认的用户名和密码是guest
		connectionFactory.setPassword("guest");

		// 用ConnectionFactory创建Connection，Connection是一个长链接，Connection里面又划分了许多信道
		Connection connection = connectionFactory.newConnection();
		// 用Connection创建信道Channel
		Channel channel = connection.createChannel();
		// ****************以上连接rabbitmq的内容和消费者是一样*****************
		
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("x-message-ttl", 10000);// 在队列里面设置消息过期时间，那么该队列里的所有消息都适用。
		channel.queueDeclare("queue_1", // 给队列起一个名称
				false, // 是否持久化
				false, // 是否排他
				false, // 是否自动删除
				arguments// 其他参数，至于有哪些参数以及key都是什么，可以通过rabbitmq的管理页面的“Queues”标签查看
		);

		String msg = "Hello World!";// 待发送的消息
		
		// 给单个消息设置过期时间TTL（Time To Live），这个时间只适用于单个消息，如果与队列的消息过期时间冲突那么该消息最终的过期时间是二者的最小值
		AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().expiration("3000").build();
		
		// 用Channel来发送消息，生产者发送消息和消费者接受消息都是通过Channel来进行的
		channel.basicPublish("exchange_1", // 要发送的交换机，如果没有指定交换机的名字，那么会发送到一个默认的交换机，名字叫“AMQP default”，该交换机的direct类型的，这时第二个参数（路由键）可以传入队列的名称，该交换机会把消息直接送到该队列里面
				"zzw_rabbitmq_test", // 路由键，由于创建的交换机类型是直连，所以routingKey必须和bindingKey一致
				// 路由键（routingKey）和绑定建（bindingKey）的关系要看交换机的类型，如果交换机的类型是直连，那么routingKey必须严格和bindingKey一致；如果交换机的类型是topic，那么bindingKey可以使用通配符；如果交换机的类型是fanout（广播），那么不需要routingKey和bindingKey
				properties, // BasicProperties，消息的其他属性，比如过期时间等
				msg.getBytes());
		
		for(int i = 1; i <= 10; i++) {
			Thread.sleep(1000);
			System.out.println(i);
		}
		
		
		// 发送完消息要将信道关闭掉，注意关闭信道不是关闭长连接，长连接是Connection
		channel.close();
		// 关闭Connection，最后在不需要长连接的时候将Connection关闭掉
		connection.close();
	}
}
