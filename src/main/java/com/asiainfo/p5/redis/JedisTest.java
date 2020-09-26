package com.asiainfo.p5.redis;

import redis.clients.jedis.Jedis;

/**
 * Redis官方推荐客户端——Jedis
 * Redis官方推荐三种Java客户端：
 * 1、Jedis：小巧轻量，但是多个线程通过同一个jedis连接会出现线程安全问题，解决方案就是使用jedis连接池，为每一个线程创建连接
 * 2、Lettuce：线程安全的
 * 3、Redisson：不仅仅是操作Redis的客户端，还提供了许多使用场景的api，比如分布式数据结构、分布式锁等。
 *
 * @author zhangzhiwang
 * @date Sep 21, 2020 2:01:09 PM
 */
public class JedisTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost", 6379);// 注意：Jedis客户端是单机模式，不能用于连接集群，否则报： redis.clients.jedis.exceptions.JedisMovedDataException: MOVE ***。如果要连接集群要使用JedisCluster
		jedis.set("k2", "bbb");
		String result = jedis.get("k2");
		System.out.println("result = " + result);
		
		jedis.close();
	}
}
