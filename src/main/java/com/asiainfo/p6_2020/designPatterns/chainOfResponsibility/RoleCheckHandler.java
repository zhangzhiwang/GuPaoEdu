package com.asiainfo.p6_2020.designPatterns.chainOfResponsibility;

public class RoleCheckHandler extends Handler {

	@Override
	protected boolean handle(User user) {
		if (!"admin".equals(user.getRole())) {
			System.out.println("不是管理员身份不许登陆！");
			return false;
		}

		return true;
	}

}
