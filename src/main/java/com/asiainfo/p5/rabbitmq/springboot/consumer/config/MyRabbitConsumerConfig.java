package com.asiainfo.p5.rabbitmq.springboot.consumer.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRabbitConsumerConfig {
	@Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {// 如果没有自定义的特殊配置，则不需要定义SimpleRabbitListenerContainerFactory的bean，因为会有默认的bean
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
//        factory.setMessageConverter(new Jackson2JsonMessageConverter());// 自定义json转换方式
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);// 需要手动应答
        factory.setAutoStartup(true);
        return factory;
    }
}
