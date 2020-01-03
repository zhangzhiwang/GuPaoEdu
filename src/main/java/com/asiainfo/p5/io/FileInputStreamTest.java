package com.asiainfo.p5.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("/Applications/Eclipse.app/Contents/Eclipse/workspace/GuPaoEdu/src/main/resources/Test.txt");
//			int read1 = fileInputStream.read();// 看read方法源码的注释：Reads a byte of data from this input stream，可以知道FileInputStream的read方法一次只读一个字节（byte）
//											  // 返回值是一个int值，源码注释：the next byte of data, or <code>-1</code> if the end of the file is reached，可以看出返回值是下一个字节，当读到文件末尾时返回-1。
//			System.out.println(read1 + "->" + (char)read1);// 英文的一个字母占一个字节
//			int read2 = fileInputStream.read();
//			System.out.println(read2 + "->" + (char)read2);
//			int read3 = fileInputStream.read();
//			System.out.println(read3 + "->" + (char)read3);
//			int read4 = fileInputStream.read();
//			System.out.println(read4 + "->" + (char)read4);
//			int read5 = fileInputStream.read();
//			System.out.println(read5 + "->" + (char)read5);
//			int read6 = fileInputStream.read();
//			System.out.println(read6);
			
			// 所以一般以while循环的方式来读
			int i = 0;
			while((i = fileInputStream.read()) != -1) {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
