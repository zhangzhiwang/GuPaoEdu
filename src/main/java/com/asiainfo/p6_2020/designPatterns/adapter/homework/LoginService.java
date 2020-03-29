package com.asiainfo.p6_2020.designPatterns.adapter.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟源角色——原有登陆服务</p>
 * 为了说明道理，代码怎么简单怎么来，所有校验全部省略
 *
 * @author zhangzhiwang
 * @date Mar 25, 2020 10:40:26 AM
 */
public class LoginService {
	private static Map<String, User> database = new HashMap<>();// 模拟数据库
	
	public static String regist(String name, String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		database.put(name, user);
		return "注册成功";
	}
	
	public static String login(String name, String password) {
		User user = database.get(name);
		if(user == null) {
			return "用户名不存在";
		} else if(!user.getPassword().equals(password)) {
			return "密码错误";
		} else {
			return "登陆成功";
		}
	}
}
