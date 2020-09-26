package com.asiainfo.p5.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * Jedis的集群模式
 *
 * @author zhangzhiwang
 * @date Sep 25, 2020 7:10:39 PM
 */
public class JedisClusterTest {
	public static void main(String[] args) {
		JedisCluster jedisCluster = new JedisCluster(new HostAndPort("192.168.15.63", 7291));
		for(int i = 0; i < 1000; i++) {
			jedisCluster.set("cluster_" + i, "" + i);
		}
		jedisCluster.close();
	}
}
