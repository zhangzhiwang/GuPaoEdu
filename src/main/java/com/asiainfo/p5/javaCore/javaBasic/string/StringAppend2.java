/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 使用String的+操作和使用占位符输出的对性能对比
 *
 * @author Administrator
 * @date 2020年2月2日 下午12:58:04
 */
public class StringAppend2 {
	private static final Logger LOGGER = LoggerFactory.getLogger(StringAppend2.class);
	
	public static void main(String[] args) {
//		String s = "zs";
//		int age = 10;
////		System.out.printf("我叫%s，我今年%d岁了", s, age);
//		String result = String.format("我叫%s，我今年%d岁了", s, age);
//		System.out.println(result);
		
		// 性能对比
		String code = "00001";
		String errMsg = "名称有误！";
		long start  = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
//			LOGGER.debug(String.format("错误代码：%s，错误信息：%s", code, errMsg));
			String result = String.format("错误代码：%s，错误信息：%s", code, errMsg);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		long start2  = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			String result = "错误代码：" + code + "，错误信息：" + errMsg;
		}
		long end2 = System.currentTimeMillis();
		System.out.println(end2 - start2);
		// 从运行结果可见String.format()方法的效率要远低于String的“+”操作
	}
}
