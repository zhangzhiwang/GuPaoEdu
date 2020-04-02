package com.asiainfo.p6_2020.designPatterns.chainOfResponsibility;

import org.jsoup.helper.StringUtil;

public class ValidHandler extends Handler {

	@Override
	protected boolean handle(User user) {
		if (StringUtil.isBlank(user.getName()) || StringUtil.isBlank(user.getPassword())) {
			System.out.println("用户名或密码为空！");
			return false;
		}
		return true;
	}

}
