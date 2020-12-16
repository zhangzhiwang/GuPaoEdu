package com.asiainfo.factory;

import com.asiainfo.entity.User;

/**
 * 通过动态工厂注入bean
 *
 * @author zhangzhiwang
 * @date Dec 15, 2020 7:28:22 PM
 */
public class DynamicFactory {
	public User getUserByDynamic() {
		return new User("wangwu", 21);
	}
}
