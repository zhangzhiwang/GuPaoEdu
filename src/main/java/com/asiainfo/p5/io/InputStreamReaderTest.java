package com.asiainfo.p5.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 字节流转换为字符流
 *
 * @author zhangzhiwang
 * @date Jan 3, 2020 6:54:52 PM
 */
public class InputStreamReaderTest {
	public static void main(String[] args) {
		try (InputStream inputStream = new FileInputStream("/Users/zhangzhiwang/Desktop/aa.txt");
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "gbk");) {// InputStreamReader是字节流与字符流的桥梁，可以将字节流转化为字符流并且能为字节流指定字符集
			int read = inputStreamReader.read();
			System.out.println(read + " -> " + (char)read);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
