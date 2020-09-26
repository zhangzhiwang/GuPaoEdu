package com.asiainfo.p5.redis;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;

/**
 * Luttuce客户端——异步模式
 *
 * @author zhangzhiwang
 * @date Sep 23, 2020 11:04:45 AM
 */
public class LettuceASyncTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		RedisClient redisClient = RedisClient.create("redis://localhost:6379");
		StatefulRedisConnection<String, String> connect = redisClient.connect();// 获取长连接
		RedisAsyncCommands<String, String> commands = connect.async();// 获取异步命令
		RedisFuture<String> resultFuture = commands.set("s1", "aaaaaaaa");
		String result = resultFuture.get(2, TimeUnit.SECONDS);
		System.out.println("set result = " + result);
		
		resultFuture = commands.get("s1");
		result = resultFuture.get(2, TimeUnit.SECONDS);
		System.out.println("get result = " + result);
	}
}
