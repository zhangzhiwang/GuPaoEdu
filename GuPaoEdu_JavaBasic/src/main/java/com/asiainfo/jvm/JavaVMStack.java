package com.asiainfo.jvm;

/**
 * java虚拟机栈
 *
 * @author zhangzhiwang
 * @date 2021年4月8日 下午7:22:43
 */
public class JavaVMStack {
	private String met1(int i, String s) {
		i = 101;
		s = "aaa";
		String str = i + s;
		return str;
	}
}
