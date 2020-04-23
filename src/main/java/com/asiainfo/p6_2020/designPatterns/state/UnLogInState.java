package com.asiainfo.p6_2020.designPatterns.state;

/**
 * 未登录状态——具体状态角色2
 *
 * @author zhangzhiwang
 * @date Apr 23, 2020 1:00:26 PM
 */
public class UnLogInState implements IState {

	@Override
	public boolean favorite() {
		System.out.println("未登录！跳转到登录页面！");
		return false;
	}

}
