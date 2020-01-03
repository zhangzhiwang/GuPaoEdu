package com.asiainfo.p5.io;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Java数据流一共有四种来源——磁盘、网络、内存和键盘
 *
 * @author zhangzhiwang
 * @date Jan 2, 2020 1:06:42 PM
 */
public class IOTest {
	public static void main(String[] args) throws Exception {
		// 针对不同来源的数据流Java IO包提供了不同的实现类来处理：
		// 1、对于来源于磁盘的数据流Java提供了FileInputStream
		InputStream inputStream = null;
		inputStream = new FileInputStream("/Applications/Eclipse.app/Contents/Eclipse/workspace/GuPaoEdu/src/main/resources/Test.txt");// 为了方便测试这里异常统一向上抛出
		
		int i = 0;
		while((i = inputStream.read()) != -1) {
			System.out.print((char)i);
		}
		
		// 2、针对来源于网络的数据流，这里涉及到socket之后再测试
		
		// 3、针对来源于内存的数据流，Java IO包提供了ByteArrayInputStream
		System.out.println("-----------");
		String s = "hello world!";
		inputStream = new ByteArrayInputStream(s.getBytes());
		int j = 0;
		while((j = inputStream.read()) != -1) {
			System.out.print((char)j);
		}
		
		// 4、针对来源于键盘的数据流
		System.out.println("-----------");
		inputStream = System.in;
		int k = 0;
		while((k = inputStream.read()) != -1) {
			System.out.print((char)k);
		}
	}
}
