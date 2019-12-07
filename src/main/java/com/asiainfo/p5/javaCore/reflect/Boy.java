package com.asiainfo.p5.javaCore.reflect;

import java.util.logging.Logger;

public class Boy implements IPerson {
	public static final Logger LOG = Logger.getLogger("com.asiainfo.p5.javaCore.reflect.IPerson");
	public int age;
	int gender;
	private int money;
	private String name;
	private static String address;
	public static String desc;

	private Boy(int age) {
		super();
		this.age = age;
	}

	public Boy() {
		super();
	}

	private Boy(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public void boyMet1(String s, int i) {
	}

	protected String boyMet2(String name) {
		return null;
	}

	int boyMet3() {
		return 0;
	}

	private void boyMet4(int age) {
	}

	private static int boyMet5() {
		return 1;
	}

	public static final void boyMet6() {
	}

	public int getMoney() {
		return money;
	}
}
