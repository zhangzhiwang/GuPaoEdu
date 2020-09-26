package com.asiainfo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置类
 *
 * @author zhangzhiwang
 * @date Sep 26, 2020 10:19:33 AM
 */
@Configuration
//@ConditionalOnClass({RedisOperations.class})
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {
	@Bean
	@ConditionalOnMissingBean(name="redisTemplate")
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());// 如果不使用序列化key发送到redis服务器上可能会有乱码 
		redisTemplate.setValueSerializer(new StringRedisSerializer());// value同理，可以根据需要选择使用其它序列化技术
		return redisTemplate;
	}
}
