package com.asiainfo.p5.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

/**
 * 基于Redisson实现分布式锁
 *
 * @author zhangzhiwang
 * @date Sep 23, 2020 11:12:18 PM
 */
public class DistributeLockTest {
	public static void main(String[] args) {
		Config config = new Config();
		config.useSingleServer().setAddress("redis://localhost:6389");
		RedissonClient redissonClient = Redisson.create(config);
		RLock rLock = redissonClient.getLock("disLock");
		if (rLock.tryLock()) {
			System.out.println("获取锁成功！");
		} else {
			System.out.println("获取锁失败！");
		}

		rLock.unlock();
		redissonClient.shutdown();
	}
}
