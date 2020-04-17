package com.asiainfo.p6_2020.designPatterns.chainOfResponsibility;

/**
 * 责任链模式——一个请求从开始被处理到最终处理结束需要好多步骤，这些步骤都分别抽取到一个类中，也就是一个类只负责处理的某一步，然后这些类的对象被串联成一个链，这些步骤之间和被处理的请求与处理之间解耦合。
 *
 * @author zhangzhiwang
 * @date Apr 2, 2020 12:09:45 PM
 */
public class ChainOfResponsibilityTest {
	public static void main(String[] args) {
		CheckService checkService = new CheckService();
		User user = new User("zs", "1234", "admin");
		boolean b = checkService.loginCheckChain2(user);
		System.out.println(b);
	}
}
