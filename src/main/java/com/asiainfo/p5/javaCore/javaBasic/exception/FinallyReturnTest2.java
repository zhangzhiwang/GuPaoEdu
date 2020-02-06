/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic.exception;

/**
 * 有个嵌套的try..catch..finally,在内部的finally中加入return会怎么样
 *
 * @author Administrator
 * @date 2020年2月4日 下午10:00:12
 */
public class FinallyReturnTest2 {
	public static void main(String[] args) {
		int i = met1();
		System.out.println(i);
	}

	@SuppressWarnings("finally")
	public static int met1() {
		int i = 10;
		try {
			System.out.println("try");
			
			
		} catch (Exception e) {
			System.out.println("catch");
			i = 20;
			return i;
		} finally {
			System.out.println("finnaly");
			i = 30;
			
			try {
				System.out.println("inner-try");
				i = 11;
			} catch (Exception e) {
				System.out.println("inner-catch");
				i = 12;
			} finally {
				System.out.println("inner-finnaly");
				i = 13;
				return i;
			}
		}
	}
}
