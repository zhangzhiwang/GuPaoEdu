package com.asiainfo.p5.rabbitmq.springboot.provider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用config类来代替xml配置
 *
 * @author zhangzhiwang
 * @date Sep 9, 2020 1:14:16 PM
 */
@Configuration
public class MyRabbitConfig {
	// **************创建交换机******************
	@Bean
	@Qualifier("firstExchange")
	public DirectExchange firstExchange() {// 各种类型的交换机被封装成各种类，比如直连类型的交换机被封装成DirectExchange类
		return new DirectExchange("firstExchange", // 交换机名称
				false, // 是否持久化
				false, // 是否自动删除
				null// 其他参数
		);
	}
	
	@Bean
	@Qualifier("secondExchange")
	public TopicExchange secondExchange() {
		return new TopicExchange("secondExchange", // 交换机名称
				false, // 是否持久化
				false, // 是否自动删除
				null// 其他参数
				);
	}
	
	@Bean
	@Qualifier("thirdExchange")
	public FanoutExchange thirdExchange() {
		return new FanoutExchange("thirdExchange", // 交换机名称
				false, // 是否持久化
				false, // 是否自动删除
				null// 其他参数
				);
	}

	// ************创建队列**************
	@Bean
	@Qualifier("firstQueue")
	public Queue firstQueue() {// 注意Queue的包名是org.springframework.amqp.core
		return new Queue("firstQueue", // 队列名称
				false, // 是否持久化
				false, // 是否排他
				false, // 是否自动删除
				null// 其他参数
		);
	}

	@Bean
	@Qualifier("secondQueue")
	public Queue secondQueue() {
		return new Queue("secondQueue", // 队列名称
				false, // 是否持久化
				false, // 是否排他
				false, // 是否自动删除
				null// 其他参数
		);
	}

	@Bean
	@Qualifier("thirdQueue")
	public Queue thirdQueue() {
		return new Queue("thirdQueue", // 队列名称
				false, // 是否持久化
				false, // 是否排他
				false, // 是否自动删除
				null// 其他参数
		);
	}

	@Bean
	@Qualifier("forthQueue")
	public Queue forthQueue() {
		return new Queue("forthQueue", // 队列名称
				false, // 是否持久化
				false, // 是否排他
				false, // 是否自动删除
				null// 其他参数
		);
	}
	
	// ***************交换机和队列进行绑定*******************
	@Bean
	public Binding bindFirst(@Qualifier("firstExchange") DirectExchange exchange, @Qualifier("firstQueue") Queue queue) {// 直连交换机和firstQueue进行绑定
		return BindingBuilder.bind(queue).to(exchange).with("zzw");// with的参数是路由键
	}
	
	@Bean
	public Binding bindSecond(@Qualifier("secondExchange") TopicExchange exchange, @Qualifier("secondQueue") Queue queue) {// 主题交换机和secondQueue进行绑定
		return BindingBuilder.bind(queue).to(exchange).with("#.zzw.*");// 由两种通配符#和*：“#”匹配零个或多个单词，符号“*”仅匹配一个单词（有且只有一个词）。注意匹配的是单词不是字符，单词和单词之间用“.”分割，“a.b”是两个单词，“a”是一个单词。
	}
	
	@Bean
	public Binding bindThird(@Qualifier("thirdExchange") FanoutExchange exchange, @Qualifier("thirdQueue") Queue queue) {// 广播交换机和thirdQueue和forthQueue进行绑定
		return BindingBuilder.bind(queue).to(exchange);
	}
	
	@Bean
	public Binding bindForth(@Qualifier("thirdExchange") FanoutExchange exchange, @Qualifier("forthQueue") Queue queue) {// 广播交换机和thirdQueue和forthQueue进行绑定
		return BindingBuilder.bind(queue).to(exchange);
	}
}
