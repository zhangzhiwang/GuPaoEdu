package com.asiainfo.p6_2020.designPatterns.state;

/**
 * 已登录状态——具体状态角色1
 *
 * @author zhangzhiwang
 * @date Apr 23, 2020 1:00:26 PM
 */
public class LoggedInState implements IState {

	@Override
	public boolean favorite() {
		System.out.println("收藏文章成功！");
		return true;
	}

}
