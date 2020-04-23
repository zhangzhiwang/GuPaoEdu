package com.asiainfo.p6_2020.designPatterns.state;

/**
 * 上下文角色（用于切换状态）
 *
 * @author zhangzhiwang
 * @date Apr 23, 2020 1:03:00 PM
 */
public class Context {
	private IState current;
	private IState defaultState = new UnLogInState();// 默认处于未登录状态

	public Context() {
		current = defaultState;
	}

	public void setState(IState state) {
		current = state;
	}

	public IState getState() {
		return current;
	}

	public boolean isLoggedIn() {
		return current instanceof LoggedInState;
	}
	
	public void favorite() {
		boolean b = current.favorite();
		if(!b) {
			setState(new LoggedInState());
			favorite();
		}
	}
}
