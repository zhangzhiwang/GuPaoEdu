package com.asiainfo.p5.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

/**
 * 使用Jedis测试Sentinel
 * 关于sentinel配置文件的内容可以参考：https://blog.csdn.net/u012441222/article/details/80751390
 * Redis的master节点出现故障时需要进行故障转移，如果使用sentinel的话那么由sentinel来进行，如果sentinel也是一个集群的话，那么sentinel之间要选举出一个leader，由leader进行redis集群的故障转移。
 * 这个选举过程采用的Raft算法，简单地说就是一个sentinel发现master节点挂了，会询问其它sentinel节点master是不是挂了，如果超过半数的sentinel认为master挂了，那么master被认为客观下线。
 * 这个时候要进行sentinel的leader选举，发现master挂了的那个sentinel会向其它sentinel节点投票（投自己），如果其它sentinel没有投过别人就同意否则就不同意，当过半数的sentinel都同意那么这个sentinel就称为了leader，由它来进行redis集群的故障转移。
 * 注意这个选举是临时的，当故障转义之后各sentinel节点又恢复成“地位平等”的了。
 *
 * @author zhangzhiwang
 * @date Sep 24, 2020 7:40:24 PM
 */
public class SentinelTest {
	public static void main(String[] args) {
		// sentinel集群
		Set<String> set = new HashSet<>();
		set.add("192.168.15.63:26379");
		set.add("192.168.15.85:26379");
		set.add("192.168.15.88:26379");
		// 客户端连接sentinel，从sentinel获取集群中的master地址，然后客户端去连接master操作
		// sentinel里面配置了redis集群的master节点，通过master节点找到slave节点从而找到所有集群节点进行监控
		JedisSentinelPool jedisSentinelPool = new JedisSentinelPool("redis-master", set);// masterName和sentinel.conf里面的配置相同
		
		Jedis jedis = jedisSentinelPool.getResource();
		jedis.set("s1", "11111");
		String result = jedis.get("s1");
		System.out.println("result = " + result);
	}
}
