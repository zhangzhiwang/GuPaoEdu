package com.asiainfo.p6_2020.designPatterns.command;

/**
 * 播放器内核——命令接收者（功能实现者）角色
 *
 * @author zhangzhiwang
 * @date Apr 20, 2020 11:25:52 AM
 */
public class PlayerCore {
	public void play() {
		System.out.println("播放视频");
	}
	
	public void pause() {
		System.out.println("暂停视频");
	}
	
	public void stop() {
		System.out.println("停止视频");
	}
}
