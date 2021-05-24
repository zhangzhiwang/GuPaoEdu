package com.asiainfo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 字节字符转换流——将字节流转换为字符流
 *
 * @author zhangzhiwang
 * @date 2021年4月15日 下午5:26:58
 */
public class InputStreamReaderTest {
	public static void main(String[] args) {
		try (InputStreamReader reader = new InputStreamReader(new FileInputStream("/Users/zhangzhiwang/Desktop/test.txt"), "utf-8");
				OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("/Users/zhangzhiwang/Desktop/test_2.txt"), "utf-8")) {
			int i = 0;
			char[] c = new char[2];// 相当于字节流的byte数组，字符流要用char数组
			while((i = reader.read(c)) != -1) {
				writer.write(c, 0, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
