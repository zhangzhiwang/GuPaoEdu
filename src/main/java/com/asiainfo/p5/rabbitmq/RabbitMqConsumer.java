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
 * rabbitmq消费者
 *
 * @author zhangzhiwang
 * @date Aug 25, 2020 12:32:26 PM
 */
public class RabbitMqConsumer {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("127.0.0.1");// 设置rabbitmq服务器的ip和端口
		connectionFactory.setPort(5672);// 15672是给浏览器访问rabbitmq的管理界面用的端口，程序连rabbitmq服务器的端口默认是5672
		connectionFactory.setVirtualHost("/");// 设置虚拟主机（VHost）地址，默认的VHost就是“/”。每一个exchange都归属于一个VHost，VHost起到对exchange的隔离作用，使不同VHost下的exchange互相不受影响，类似Java中的package
		connectionFactory.setUsername("guest");// rabbitmq默认的用户名和密码是guest
		connectionFactory.setPassword("guest");
//		connectionFactory.setConnectionTimeout(30000);

		// 用ConnectionFactory创建Connection
		Connection connection = connectionFactory.newConnection();
		// 用Connection创建信道Channel
		Channel channel = connection.createChannel();
		// 用Channel声明交换机
		channel.exchangeDeclare("exchange_1", // 给交换机起一个名字
				"direct", // 交换机的类型：直连（direct）、主题（topic）、广播（fanout）还有一个不常用的headers。注意这里的topic是交换机的类型，支持通配符，和其他消息队列的topic不是一个概念
				false, // 是否持久化
				false, // 是否自动删除
				null// 其他参数
		);
		// 用Channel声明队列
		channel.queueDeclare("queue_1", // 给队列起一个名称
				false, // 是否持久化
				false, // 是否排他
				false, // 是否自动删除
				null// 其他参数
		);
		// 用Channel来绑定交换机和队列
		channel.queueBind("queue_1", // 要绑定的队列名字
				"exchange_1", // 要绑定的交换机名字
				"zzw_rabbitmq_test"// 绑定建（bindingKey）
		);
		// *****************生产上以上资源一般不是通过代码来创建的，而是由运维人员在rabbitmq界面上去创建的*****************

		// 创建消费者
		Consumer consumer = new DefaultConsumer(channel) {
			// 需要重写DefaultConsumer类的handleDelivery方法，因为它里面什么都没做。这个方法是消费者收到消息后回调的方法
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				System.out.println("consumerTag" + consumerTag);
				System.out.println("envelope" + envelope);
				System.out.println("properties" + properties);
				System.out.println("body" + new String(body, "UTF-8"));
				System.out.println("-------------------------------------");
			}
		};

		// 用Channel来获取消息
		channel.basicConsume("queue_1", // 监听的队列
				consumer// 回调的方法
		);
		
		// 消费者不需要关闭Channel，因为它要通过Channel始终监听队列
	}
}
