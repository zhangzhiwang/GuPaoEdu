package com.asiainfo.p5.rabbitmq.deadLeter;

import java.util.HashMap;
import java.util.Map;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 死信交换机和死信队列
 *
 * @author zhangzhiwang
 * @date Aug 27, 2020 7:25:37 PM
 */
public class DeadLetterProvider {
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("127.0.0.1");
		connectionFactory.setPort(5672);// 注意浏览器访问控制平台的端口默认是是15672，代码连接rabbitmq的端口默认是5672
		connectionFactory.setVirtualHost("new_vhost_2");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		// 声明正常的交换机
		channel.exchangeDeclare("normal_exchange", "direct", false, false, null);
		
		// 声明正常的队列
		Map<String, Object> arguments = new HashMap<String, Object>();
		arguments.put("x-dead-letter-exchange", "zzw_deadLetterExchange");// 具体key是什么可以到rabbitmq管理界面的“Queues”标签查看
		arguments.put("x-dead-letter-routing-key", "#");// 死信的路由键，规定具有什么样key的死信可以进入死信队列，这里的“#”代表具有任意key的死信都可以进入死信队列
														// 注1:这里的routing-key是规定正常队列和死信交换机的key路由规则
//		arguments.put("x-max-length", 1);// 使消息成为死信情况2
		channel.queueDeclare("normal_queue", false, false, false, arguments);
		// 绑定正常的交换机和队列
		channel.queueBind("normal_queue", "normal_exchange", "key123");
		
		// 声明死信交换机
		channel.exchangeDeclare("zzw_deadLetterExchange", "direct", false, false, null);
		channel.queueDeclare("zzw_deadLetterQueue", false, false, false, null);
		// 绑定死信交换机和死信队列
		channel.queueBind("zzw_deadLetterQueue", "zzw_deadLetterExchange", "#");// 注2:这里的routing-key是规定死信交换机和死信队列的key路由规则
		
		// 往普通交换机发送消息
		String msg = "死信队列测试";
		/**
		 * 有三种情况可以让一个信息成为死信：
		 * 1、消息过期，即达到了TTL所规定的时间
		 * 2、消息被消费者拒收后没有将该消息重新放入队列
		 * 3、消息挤压超过了队列的容量，即x-max-length或x-max-length-bytes
		 */
//		AMQP.BasicProperties props = new AMQP.BasicProperties().builder().expiration("10000").build();// 使消息成为死信情况1。消息队列本质上是一个队列，队列就是FIFO的，所以到期的时候先从队列头来时移除
		channel.basicPublish("normal_exchange", "key123", null, msg.getBytes());
		
		channel.close();
		connection.close();
	}
}
