package com.asiainfo.factory;

import com.asiainfo.entity.User3;

/**
 * 通过动态工厂注入bean
 *
 * @author zhangzhiwang
 * @date Dec 15, 2020 7:28:22 PM
 */
public class DynamicFactory {
	public User3 getUserByDynamic() {
		return new User3("wangwu", 21);
	}
}
