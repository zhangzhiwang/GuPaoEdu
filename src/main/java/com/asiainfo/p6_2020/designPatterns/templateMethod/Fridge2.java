package com.asiainfo.p6_2020.designPatterns.templateMethod;

public class Fridge2 extends RefrigeratorTemplate {

	@Override
	protected void putElephant() {
		System.out.println("把亚洲大象放进去");
	}

	@Override
	protected boolean needClean() {
		return false;
	}

}
