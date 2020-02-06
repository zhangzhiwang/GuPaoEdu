/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic.exception;

import java.io.IOException;

/**
 * 运行时异常
 *
 * @author Administrator
 * @date 2020年2月4日 下午7:13:30
 */
public class RuntimeExceptionTest {
	public static void main(String[] args) {
		met1();
		try {
			met2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void met1() throws RuntimeException {}
	
	public static void met2() throws IOException {}
}
