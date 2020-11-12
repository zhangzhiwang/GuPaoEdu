package com.asiainfo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**
 * spb和redis的整合步骤（这里使用的是Jedis客户端）：
 * 1、引入依赖：spring-boot-starter-data-redis和jedis
 * 2、配置文件里面进行配置
 * 3、编写配置类
 * 4、在需要的地方注入RedisTemplate并进行使用
 *
 * @author zhangzhiwang
 * @date Nov 11, 2020 11:27:24 PM
 */
@Configuration
public class RedisConfig {
	@Bean
	@ConditionalOnMissingBean(name="redisTemplate")
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());// 如果不使用序列化key发送到redis服务器上可能会有乱码，这里使用的是字符串序列化器
//		redisTemplate.setValueSerializer(new StringRedisSerializer());// value同理，可以根据需要选择使用其它序列化技术
//		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());// 使用jdk自带序列化器，可以将类对象序列化传输到redis服务器
		return redisTemplate;
	}
}
