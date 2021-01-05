package com.asiainfo.factory;

import com.asiainfo.entity.User3;

/**
 * 通过静态工厂注入bean
 *
 * @author zhangzhiwang
 * @date Dec 15, 2020 7:28:22 PM
 */
public class StaticFactory {
	public static User3 getUserByStatic() {
		return new User3("lisi", 20);
	}
}
