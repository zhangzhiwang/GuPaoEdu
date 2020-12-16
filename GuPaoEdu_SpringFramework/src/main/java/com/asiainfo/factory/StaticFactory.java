package com.asiainfo.factory;

import com.asiainfo.entity.User;

/**
 * 通过静态工厂注入bean
 *
 * @author zhangzhiwang
 * @date Dec 15, 2020 7:28:22 PM
 */
public class StaticFactory {
	public static User getUserByStatic() {
		return new User("lisi", 20);
	}
}
