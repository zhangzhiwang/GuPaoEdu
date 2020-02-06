/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic.exception;

/**
 * return和finally测试
 *
 * @author Administrator
 * @date 2020年2月4日 下午10:00:12
 */
public class FinallyReturnTest {
	public static void main(String[] args) {
		int i = met1();
		System.out.println(i);
	}

	@SuppressWarnings("finally")
	public static int met1() {
		int i = 10;
		try {
//			System.out.println("try");
			return i;
		} catch (Exception e) {
//			System.out.println("catch");
			i = 20;
			return i;
		} finally {
//			System.out.println("finnaly");
			i = 30;
//			return i;
		}
	}
}
