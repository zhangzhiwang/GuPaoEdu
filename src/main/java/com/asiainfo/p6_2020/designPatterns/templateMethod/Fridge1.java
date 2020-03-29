package com.asiainfo.p6_2020.designPatterns.templateMethod;

public class Fridge1 extends RefrigeratorTemplate {

	@Override
	protected void putElephant() {
		System.out.println("把非洲大象放进去");
	}

	@Override
	protected void openFridge() {
		System.out.println("用遥控来开冰箱");
	}

	@Override
	protected boolean needClean() {
		return true;
	}

	@Override
	protected void cleanFridge() {
		System.out.println("清理冰箱");
	}
	
}
