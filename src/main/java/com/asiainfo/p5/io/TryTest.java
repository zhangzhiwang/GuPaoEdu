package com.asiainfo.p5.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * try的不常见用法，jdk1.7出现的
 *
 * @author zhangzhiwang
 * @date Jan 3, 2020 8:34:22 PM
 */
public class TryTest {
	public static void main(String[] args) {
		/**
		 * try() {}catch() {}</p>
		 * try后面有小括号的用法，小括号里面可以自动关闭流，前提是这个输入流或者输出流的类要实现Closeable接口
		 */
		try(InputStream inputStream = new FileInputStream("/Applications/Eclipse.app/Contents/Eclipse/workspace/GuPaoEdu/src/main/resources/Test.txt");
				OutputStream outputStream = new FileOutputStream("/Applications/Eclipse.app/Contents/Eclipse/workspace/GuPaoEdu/src/main/resources/Test_2.txt");
				) {
			byte[] buffer = new byte[3];
			int i = 0;
			while((i = inputStream.read(buffer, 0, buffer.length)) != -1) {
				outputStream.write(buffer, 0, i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
