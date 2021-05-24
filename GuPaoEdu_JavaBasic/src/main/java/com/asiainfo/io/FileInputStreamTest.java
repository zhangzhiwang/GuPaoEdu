package com.asiainfo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * java的io体系一共有五大核心类：File、InputStream、OutputStream、Reader、Writer
 * 字节流：InputStream和OutputStream，可以操作任何类型的文件
 * 字符流：Reader和Writer，只能操作文本类型的数据
 * 根据数据流来源的介质不同（比如：磁盘、网络、内存、键盘）需要使用字节流或者字符流的不同的实现类来操作。
 * 数据流来源介质是磁盘的文件一般使用FileInputStream和FileOutputStream
 * “出”和“入”是相对某个参照物来说的，java IO的“输入”和“输出”是相对内存来说的，进入内存叫“输入”，出内存”叫输出“。
 *
 * @author zhangzhiwang
 * @date 2021年4月14日 上午11:16:32
 */
public class FileInputStreamTest {
	public static void main(String[] args) {
		// 需求：从磁盘上读取文件到内存中
		// 由于数据流的来源介质是磁盘而且操作的是文件，所以采用字节流InputStream的实现类FileInputStream来操作。test.txt文件的内容为：Aa !
		try(FileInputStream in = new FileInputStream("/Users/zhangzhiwang/Movies/test.txt");) {
//			int i = in.read();// 一次性读取一个字节，返回ASCII码的数字表示
//			System.out.print(i + " -> " + (char)i);
//			System.out.println();
//			i = in.read();
//			System.out.print(i + " -> " + (char)i);
//			System.out.println();
//			i = in.read();
//			System.out.print(i + " -> " + (char)i);
//			System.out.println();
//			i = in.read();
//			System.out.print(i + " -> " + (char)i);
//			System.out.println();
//			i = in.read();
//			System.out.print(i + " -> " + (char)i);
//			System.out.println();
//			i = in.read();
//			System.out.print(i + " -> " + (char)i);
			/**
			 * 打印结果为：
			 *  65 -> A
				97 -> a
				32 ->  
				33 -> !
				-1 -> ￿
				-1 -> ￿
				所以，要想获取文件的所有内容要写一个循环
			 */
			// 使用while循环
//			int j = 0;
//			while((j = in.read()) != -1) {
//				System.out.print((char)j);
//			}
			
			// 使用for循环，要想使用for循环必须知道要循环多少次
			int available = in.available();// 返回剩余能读取到的字节总个数，注意是“剩余”，in.read()一次，in.available()就少一个
			for(int i = 0; i < available; i++) {
				int read = in.read();
				System.out.print((char)read);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
