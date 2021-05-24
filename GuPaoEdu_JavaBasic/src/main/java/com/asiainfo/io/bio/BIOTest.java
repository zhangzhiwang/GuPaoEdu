package com.asiainfo.io.bio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BIOTest {
	public static void main(String[] args) {
		// 基于磁盘的channel使用FileChannel，基于网络的channel可以使用ServerSocketChannel
		try (FileInputStream in = new FileInputStream("/Users/zhangzhiwang/Desktop/1.png"); 
				FileChannel fin = in.getChannel();
				FileOutputStream out = new FileOutputStream("/Users/zhangzhiwang/Desktop/1_2.png");
				FileChannel fout = out.getChannel();
				) {
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int count = 0;// 统计一共循环多少次
			while(fin.read(buffer) != -1) {
				count++;
				buffer.flip();// 缓冲反转，输入和输出进行反转。本质上是控制指针和limit的值。
				fout.write(buffer);
				buffer.clear();// 缓冲重置
			}
			System.out.println("一共循环：" + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
