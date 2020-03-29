package com.asiainfo.p6_2020.designPatterns.templateMethod;

/**
 * 模版方法模式——将做一件事情的步骤封装到抽象类里面，这些步骤子类是不能改变的，具体某一步该怎么做子类可以自定义
 *
 * @author zhangzhiwang
 * @date Mar 26, 2020 10:57:48 AM
 */
public class TemplateMethodTest {
	public static void main(String[] args) {
		RefrigeratorTemplate t = new Fridge1();
		t.putEleIntoFridge();
		
		System.out.println("----------");
		t = new Fridge2();
		t.putEleIntoFridge();
	}
}