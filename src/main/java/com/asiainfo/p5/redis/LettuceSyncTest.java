package com.asiainfo.p5.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * Luttuce客户端——同步模式
 *
 * @author zhangzhiwang
 * @date Sep 23, 2020 11:04:45 AM
 */
public class LettuceSyncTest {
	public static void main(String[] args) {
		RedisClient redisClient = RedisClient.create("redis://localhost:6379");
		StatefulRedisConnection<String, String> connect = redisClient.connect();// 建立长连接
		RedisCommands<String, String> sync = connect.sync();// 获取同步执行的命令
		String result = sync.set("s1", "112233");
		System.out.println("result = " + result);
		result = sync.get("s1");
		System.out.println("result = " + result);
		
		connect.close();// 关闭连接
		redisClient.shutdown();// 关闭客户端
	}
}
