package com.asiainfo.p6_2020.designPatterns.chainOfResponsibility;

public class LoginCheckHandler extends Handler {

	@Override
	protected boolean handle(User user) {
		User u = getLoginUser(user.getName(), user.getPassword());
		if (u == null) {
			System.out.println("用户名或密码错误或不存在该用户！");
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
