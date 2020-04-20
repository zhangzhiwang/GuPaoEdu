package com.asiainfo.p6_2020.designPatterns.command;

/**
 * 暂停按钮——具体命令角色，注意不是命令实现角色，而是中间件的实现者
 *
 * @author zhangzhiwang
 * @date Apr 20, 2020 11:34:06 AM
 */
public class PauseController implements Controller {
	private PlayerCore playerCore;

	{
		playerCore = new PlayerCore();// 模拟spring注入
	}

	public void execute() {
		playerCore.pause();
	}
}
