package com.asiainfo.p5.javaCore.regex;

/**
 * 正则表达式
 *
 * @author zhangzhiwang
 * @date Feb 15, 2020 3:16:37 PM
 */
public class Regex {
	public static void main(String[] args) {
		String regex = "\\d{1,3}[0-255]";
		String test = "0";
		System.out.println(test.matches(regex));
	}
}
