package com.asiainfo.p5.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * 用Jedis实现发布订阅模式——订阅者
 *
 * @author zhangzhiwang
 * @date Sep 22, 2020 11:27:15 AM
 */
public class SubscribeTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost", 6379);
//		jedis.psubscribe(new MyListener(), "news*");
		jedis.subscribe(new MyListener(), "sport", "weather", "interview");// 订阅多个频道
	}

	static class MyListener extends JedisPubSub {
		public void onMessage(String channel, String message) {
			System.out.println("channel = " + channel + ",message = " + message);
		}

		public void onPMessage(String pattern, String channel, String message) {
			System.out.println("channel = " + channel + ",message = " + message + ",pattern = " + pattern);
		}
	}
}
