package com.asiainfo.p6_2020.designPatterns.delegate;

/**
 * 委派模式——委派者自己不执行具体的任务而是把任务分配给能执行这个任务的人去完成
 *
 * @author zhangzhiwang
 * @date Mar 26, 2020 9:43:19 AM
 */
public class DelegateTest {
	public static void main(String[] args) {
		Boss boss = new Boss();
		TeamLeader teamLeader = new TeamLeader();
		boss.command("webPage", teamLeader);
		boss.command("java", teamLeader);
		boss.command("c++", teamLeader);
		
		/**
		 * 委派模式和代理模式的区别：</p>
		 * 委派模式就是静态代理模式，委派模式强调的是任务的分发、转达和调度，目的是找合适的人去完成指定任务，而代理模式强调的是增强，对被代理类功能的增强
		 */
		
		/**
		 * 委派模式在源码中的运用：ClassLoader的双亲委派机制，查看ClassLoader类的loadClass方法
		 */
	}
}
