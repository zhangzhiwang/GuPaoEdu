package com.asiainfo.p5.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * JedisPool
 *
 * @author zhangzhiwang
 * @date Sep 26, 2020 2:39:39 PM
 */
public class JedisPoolTest {
	public static void main(String[] args) {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6389);// 使用的是docker创建的redis，宿主机的端口是6389
		Jedis jedis = jedisPool.getResource();
		jedis.set("s2", "1");
		String result = jedis.get("s2");
		System.out.println(result);
		
		jedis.close();// 通过close的源码可以看出如果是从资源池取的jedis实例关闭的时候就归还资源池，否则直接close掉，断开与redus服务器的连接
	}
}
