package com.asiainfo.util;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Redis工具类
 *
 * @author zhangzhiwang
 * @date Sep 26, 2020 10:28:14 AM
 */
@Component
public class RedisUtil {
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> redisTemplate;

	public boolean set(String key, String value) {
		try {
			redisTemplate.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
}
