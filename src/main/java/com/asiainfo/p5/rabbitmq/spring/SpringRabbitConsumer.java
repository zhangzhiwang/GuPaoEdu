package com.asiainfo.p5.rabbitmq.spring;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Rabbit和Spring（注意不是SpringBoot）整合的Consumer写法，要实现MessageListener接口，onMessage方法是收到消息后的回调方法
 *
 * @author zhangzhiwang
 * @date Sep 8, 2020 7:24:32 PM
 */
@Component 
public class SpringRabbitConsumer implements MessageListener {

	@Override
	public void onMessage(Message message) {
		System.out.println("message = " + new String(message.getBody()));
	}

}
