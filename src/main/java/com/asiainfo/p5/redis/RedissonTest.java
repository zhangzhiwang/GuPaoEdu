package com.asiainfo.p5.redis;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

/**
 * Redisson客户端
 *
 * @author zhangzhiwang
 * @date Sep 23, 2020 10:49:49 AM
 */
public class RedissonTest {
	public static void main(String[] args) {
		Config config = new Config();
		config.setCodec(new StringCodec());
		// 使用单节点
		config.useSingleServer().setAddress("redis://localhost:6379");
		
		RedissonClient redissonClient = Redisson.create(config);
		// 获取key-value键值对对象
		RBucket<String> rBucket = redissonClient.getBucket("s1");// 参数为key，可以不存在没关系
		rBucket.set("aaa");// 参数为value值，如果可以不存在则直接创建key并设置值为value，如果存在则覆盖值
		
		// 最后要关闭
		redissonClient.shutdown();
	}
}
