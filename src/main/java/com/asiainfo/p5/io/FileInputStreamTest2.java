package com.asiainfo.p5.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * InputStream的三个read方法
 *
 * @author zhangzhiwang
 * @date Jan 2, 2020 10:03:04 PM
 */
public class FileInputStreamTest2 {
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("/Applications/Eclipse.app/Contents/Eclipse/workspace/GuPaoEdu/src/main/resources/Test.txt");
//			int i = fileInputStream.read();// 一次读取一个字节
//			System.out.println((char)i);
			
			byte[] bs = new byte[2];
//			int i = fileInputStream.read(bs);// 一次性读取bs.length个字节的数据并放到字节数组bs里面，从该方法的官方注释可以看到：Reads up to <code>len</code> bytes of data from this input stream into an array of bytes。
//			System.out.println(i);
//			for(byte b : bs) {
//				System.out.println((char)b);
//			}
			
			int i = fileInputStream.read(bs, 0, bs.length);
			System.out.println(i);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
