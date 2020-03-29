package com.asiainfo.p6_2020.designPatterns.adapter.homework;

/**
 * 模拟场景：原有功能是提供用户名和密码来登陆系统，现在假如不同的第三方平台来登陆
 *
 * @author zhangzhiwang
 * @date Mar 25, 2020 10:39:32 AM
 */
public class LoginTest {
	public static void main(String[] args) {
		// 原始功能只提供用户名和密码登陆
		String regist = LoginService.regist("zs", "123");
		System.out.println(regist);
		
		String login = LoginService.login("zs", "123");
		System.out.println(login);
		
		// 新需求：增加第三方登录，首先增加qq登陆
		// 暂略
		
		/**
		 * 适配器模式在源码中到处可见，只要是带“Adapter”的都是适配器模式，就不举例了 
		 */
	}
}
