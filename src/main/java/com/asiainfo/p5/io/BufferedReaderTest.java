package com.asiainfo.p5.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 带缓冲的输入输出流
 *
 * @author zhangzhiwang
 * @date Jan 7, 2020 4:27:39 PM
 */
public class BufferedReaderTest {
//	public static void main(String[] args) {
//		// BufferedReader和BufferedWriter是带缓冲的字符流，和BufferedInputStream/BufferedOutputStream类似
//		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/zhangzhiwang/Desktop/Test.txt"));
//				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/zhangzhiwang/Desktop/Test_2.txt"))) {
////			int read = bufferedReader.read();// 一次读取一个字符
////			System.out.println(read + " -> " + (char)read);
////			read = bufferedReader.read();
////			System.out.println(read + " -> " + (char)read);
//			
////			System.out.println(bufferedReader.readLine());// 一次读取一行
////			System.out.println(bufferedReader.readLine());
////			System.out.println(bufferedReader.readLine());
//			
//			String line = null;
//			while((line = bufferedReader.readLine()) != null) {
//				bufferedWriter.write(line);
//				bufferedWriter.newLine();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public static void main(String[] args) {
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("/Users/zhangzhiwang/Desktop/Test.txt"));
			bufferedWriter = new BufferedWriter(new FileWriter("/Users/zhangzhiwang/Desktop/Test_2.txt"));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
//			bufferedWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
