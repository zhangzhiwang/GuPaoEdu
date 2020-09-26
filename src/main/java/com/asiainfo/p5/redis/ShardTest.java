package com.asiainfo.p5.redis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Client;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Redis数据分片
 * 正常情况下，redis集群只有master负责数据的写入，那如果有超大量的数据在master节点的硬盘和内存装不下怎么办？
 * 这时就要考虑数据分片，即把全量的数据分在不同的机器上存储来解决master但节点存储不下的问题，每个节点存储的数据都不同。
 * 数据分片的方式有三种：
 * 1、客户端实现数据的分片，即客户端来决定把什么样的数据发到哪台机器上。缺点：要写死服务端ip。
 * 2、转发代理，即把“决定把什么样的数据发到哪台机器上”这个指责单独抽取出出来形成一个服务，所有客户端连接这个服务，由这个服务负责数据的转发。可以使用TwemProxy、Codis
 * 3、服务端，redis集群只能master节点可以处理写请求，也就是所有的写请求都会打到master上面，一个master磁盘不够用就进行水平扩容，集群中多增加几个master节点（即集群中不只有一个mater），这样写请求就会平摊到这几个master上
 *
 * @author zhangzhiwang
 * @date Sep 25, 2020 10:56:17 AM
 */
public class ShardTest {
	public static void main(String[] args) {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		
		JedisShardInfo jedisShardInfo1 = new JedisShardInfo("192.168.15.63", 6379);// 这三台机器并无主从关系，是互相独立的节点
		JedisShardInfo jedisShardInfo2 = new JedisShardInfo("192.168.15.85", 6379);
		JedisShardInfo jedisShardInfo3 = new JedisShardInfo("192.168.15.88", 6379);
		
		List<JedisShardInfo> jedisShardInfoList = new ArrayList<>();
		jedisShardInfoList.add(jedisShardInfo1);
		jedisShardInfoList.add(jedisShardInfo2);
		jedisShardInfoList.add(jedisShardInfo3);
		
		ShardedJedisPool shardedJedisPool = new ShardedJedisPool(jedisPoolConfig, jedisShardInfoList);
		ShardedJedis shardedJedis = shardedJedisPool.getResource();
		for(int i = 0; i < 100; i++) {
			shardedJedis.set("s" + i, "" + i);
		}
		
		for(int i = 0; i < 100; i++) {
			Client client = shardedJedis.getShard("s" + i).getClient();
			System.out.println("value = " + shardedJedis.get("s" + i) + ",该数据位于节点：" + client.getHost() + ":" + client.getPort());
		}
	}
	
	/**
	 * redis高可用解决方案可以分为两种方式：
	 * 1、主从复制（Replication-Sentinel）模式
	 * 	  master节点负责读和写，slave节点负责读，当master挂掉之后不能自动进行master选举，需要借助sentinel实现。该模式下master节点装有所有数据。
	 * 2、Redis集群（Redis-Cluster）模式
	 *    Redis集群在该模式下会有多个master节点，每个节点负责存储一部分数据，即数据分片，每个master存储的数据各不相同，这样解决了单点master数据装不下的问题，然后每个mater又有多个slave节点。
	 *    启动集群模式可以在每个节点的配置文件里面加上cluster-enabled yes，然后启动所有节点，这时每个节点都是独立的，相互之间没有任何关联，然后使用命令：
	 *    ./src/redis-cli --cluster create --cluster-replicas 1 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005 127.0.0.1:7006
	 *    --cluster-replicas的值1代表一个master需要有一个slave作为副本，后面跟上所有节点的ip:port，这样系统会自动创建主从节点。一般情况下要保证master至少3台，一个master至少有一个slave，即6个节点3主3从
	 */
}
