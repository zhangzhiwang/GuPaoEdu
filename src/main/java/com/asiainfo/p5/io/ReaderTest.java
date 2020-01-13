package com.asiainfo.p5.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * 字符流——专门处理文本文件
 *
 * @author zhangzhiwang
 * @date 2020年1月5日 下午2:40:55
 */
public class ReaderTest {
//	public static void main(String[] args) {
//		try (InputStream inputStream = new FileInputStream("/Users/zhangzhiwang/Desktop/aa.txt");
//				Reader reader = new FileReader("/Users/zhangzhiwang/Desktop/aa.txt", Charset.forName(""))) {
////			int read = inputStream.read();// 因为不带参数的read方法是读取一个字节，而一个汉字最少占用两个字节，所以用read()方法来读取汉语是不行的。
////			System.out.println((char) read);
//
//			// 如果要改进可以定义一个缓冲数组
////			byte[] buffer = new byte[3];// 本地文件是UTF-8格式的，将数组长度设置为3目的是一次读取一个汉字
////			int i = 0;
////			while ((i = inputStream.read(buffer)) != -1) {
////				System.out.print(new String(buffer, 0, i));
////			}
//			
//			// Java IO包提供了专门处理字符的输入输出流——字符流
//			int read = reader.read();// 一次读取一个字符
//			System.out.println(read + " -> " + (char)read);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
