package com.asiainfo.p6_2020.designPatterns.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.helper.StringUtil;

/**
 * 数据校验服务
 *
 * @author zhangzhiwang
 * @date Apr 2, 2020 1:50:33 PM
 */
public class CheckService {
	public boolean loginCheck(User user) {
		// 正常编程方式将数据校验的三个步骤耦合到一起了
		// step1:校验用户名密码不能为空
		if (StringUtil.isBlank(user.getName()) || StringUtil.isBlank(user.getPassword())) {
			System.out.println("用户名或密码为空！");
			return false;
		}

		// step2:根据用户名和密码到数据库查询
		User u = getLoginUser(user.getName(), user.getPassword());
		if (u == null) {
			System.out.println("用户名或密码错误或不存在该用户！");
			return false;
		}

		// step3:校验是不是为管理员（假设需求要求该系统只有管理员才能登陆）
		if (!"admin".equals(u.getRole())) {
			System.out.println("不是管理员身份不许登陆！");
			return false;
		}

		return true;
	}

	private User getLoginUser(String name, String password) {
		// 模拟数据库查询结果
		User user = new User("zs", "1234", "admin");
		return null;
	}
}
