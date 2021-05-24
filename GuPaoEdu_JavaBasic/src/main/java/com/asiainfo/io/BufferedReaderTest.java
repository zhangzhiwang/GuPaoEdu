package com.asiainfo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 带缓冲区的字符流，类似带缓冲区的字节流
 *
 * @author zhangzhiwang
 * @date 2021年4月15日 下午5:20:22
 */
public class BufferedReaderTest {
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader("/Users/zhangzhiwang/Desktop/test.txt"));
				BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/zhangzhiwang/Desktop/test_2.txt"));) {
//			int i = 0;
//			char[] c = new char[3];
//			while((i = reader.read(c)) != -1) {
//				writer.write(c);
//			}
			
			String line = reader.readLine();// 带缓冲的reader可以读取一行，其他类型的reader都没有readLine()方法
			writer.write(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
