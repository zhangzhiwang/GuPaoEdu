package com.asiainfo.p5.redis;

import redis.clients.jedis.Jedis;

/**
 * 用Jedis实现发布订阅模式——发布者
 *
 * @author zhangzhiwang
 * @date Sep 22, 2020 11:35:35 AM
 */
public class PublishTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost", 6379);
		jedis.publish("sport", "123");
	}
}
