package com.asiainfo.io;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * 字符流 字符流和字节流体系结构是一样的，可以类比来看
 *
 * @author zhangzhiwang
 * @date 2021年4月15日 下午5:00:23
 */
public class FileReaderTest {
	public static void main(String[] args) {
		// 基于字符流实现文件拷贝，和字节流的操作一样，只不过一个是字节流一个是字符流
		try (FileReader reader = new FileReader("/Users/zhangzhiwang/Desktop/test.txt");
				FileWriter writer = new FileWriter("/Users/zhangzhiwang/Desktop/test_2.txt");) {
			int i = 0;
			char[] c = new char[2];// 相当于字节流的byte数组，字符流要用char数组
			while((i = reader.read(c)) != -1) {
				writer.write(c, 0, i);
			}
			// FileReader没有readLine方法
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
