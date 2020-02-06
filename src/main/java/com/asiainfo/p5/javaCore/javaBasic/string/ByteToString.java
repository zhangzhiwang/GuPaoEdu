/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic.string;

/**
 * 将byte转换成String的方法
 *
 * @author Administrator
 * @date 2020年2月2日 下午8:01:27
 */
public class ByteToString {
	public static void main(String[] args) {
		byte b = 1;
		// 方式1：
		String s1 = String.valueOf(b);
		
		// 方式2：
		String s2 = "" + b;
		
		//方式3：
		String s3 = Byte.toString(b);
		
		//方式4：
		String s4 = new String(new byte[] {b});
	}
}
