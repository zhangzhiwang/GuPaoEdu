package com.asiainfo.p6_2020.designPatterns.command;

/**
 * 命令模式——将将命令的请求者和命令的接收实现者解耦，使命令调用方和命令实现方不直接交互</p>
 * 正常情况下命令调用方直接调用命令实现方的方法，但是如果使用场景中命令的实现方经常发生变化，那么会导致命令的请求方也得跟着变化，这样就不好了。那有没有一种方法当命令的实现方发生变化时，请求方不变呢？</p>
 * 这就得在二者中间引入一个“中间件”，这样调用方和中间件打交道，中间件和实现者打交道，无论实现者怎么变化，调用者是不需要变化的。现实生活中，人、遥控器、电视就具备命令模式，人和遥控器打交道，遥控器和电视打交道，这样电视的换台逻辑怎么变，命令请求方（人）的操作方式是不需要变化的。</p>
 * 命令模式的角色：</p>
 * 1、抽象命令者</p>
 * 2、具体命令角色（1和2属于中间件的继承体系）</p>
 * 3、命令接收者角色（功能的实现方）</p>
 * 4、命令请求者角色（调用方）
 *
 * @author zhangzhiwang
 * @date Apr 20, 2020 10:59:51 AM
 */
public class CommandTest {
	
	public static void main(String[] args) {
		/**
		 * 场景：人使用播放器。人是请求的发起者，播放器内核是请求的接收者并且完成请求的功能，控制条就是“中间件”。人和控制条打交道，控制条和播放器内核打交道。
		 */
		
		// 人只需要点击控制条上的按钮即可，不需要和播放器内核交互，这样内核的实现怎么变化，调用方的代码是不用变的
		Controller play = new PlayController();// 点击播放按钮
		play.execute();
		
		play = new PauseController();// 点击暂停按钮
		play.execute();
		
		play = new StopController();// 点击停止按钮
		play.execute();
		
		/**
		 * 命令模式在源码中的运用：Runnable接口可以看作是抽象命令者角色，它的实现类（线程类）可以看作是具体命令角色，调用线程start的程序是命令请求者角色，命令接收者角色（功能的实现方）实际上是CPU。客户端给线程下达命令，线程和CPU交互。
		 */
	}
}
