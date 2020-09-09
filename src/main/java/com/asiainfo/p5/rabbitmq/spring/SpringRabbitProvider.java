package com.asiainfo.p5.rabbitmq.spring;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Rabbit和Spring（注意不是SpringBoot）整合的Provider写法
 *
 * @author zhangzhiwang
 * @date Sep 8, 2020 7:38:25 PM
 */
@Component
public class SpringRabbitProvider {
	@Autowired
	@Qualifier("rabbitmqTemplate")
	private AmqpTemplate amqpTemplate;
	
	public void test() {
		amqpTemplate.convertAndSend("exchange_5", "key_5", "spring rabbit");
	}
}
