package com.asiainfo.p5.javaCore.javaBasic;

/**
 * 测试一个java文件的同级类（非内部类）
 *
 * @author zhangzhiwang
 * @date 2020年2月10日 下午5:59:54
 */
public class JavaFileTest {
	public static void main(String[] args) {
		new JavaFileTest_1();
		new JavaFileTest_2();
		new JavaFileTest_3();
	}
}

class JavaFileTest_1 {
	public static void met1() {
		new JavaFileTest();
		new JavaFileTest_1();
		new JavaFileTest_2();
		new JavaFileTest_3();
	}
}
class JavaFileTest_2 {}
class JavaFileTest_3 {}