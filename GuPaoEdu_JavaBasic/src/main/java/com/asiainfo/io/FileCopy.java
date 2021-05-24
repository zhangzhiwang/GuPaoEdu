package com.asiainfo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 输入输出流实战——文件的拷贝
 *
 * @author zhangzhiwang
 * @date 2021年4月14日 下午5:11:16
 */
public class FileCopy {
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		// 写在try()里面的类会被自动关闭，无需程序员手动关闭，但前提是括号里面的类必须实现Closeable接口
		try(FileInputStream in = new FileInputStream("/Users/zhangzhiwang/Desktop/test.txt"); 
				FileOutputStream out = new FileOutputStream("/Users/zhangzhiwang/Desktop/test_2.txt");) {
//			int i = 0;
//			while ((i = in.read()) != -1) {
//				out.write(i);// 这种方式是逐个字节写入，即从磁盘读取一个字节然后往磁盘写入一个字节，每写入一次就和磁盘有一次的io交互。假如文件一共有1k大小，那么在往磁盘写数据总共要交互1024次。
//			}
			int j = 0;
			
			/**
			 * 自定义的数组b位于用户空间，read方法实际的操作有三部分：
			 * 1、内核给磁盘控制器发送命令：我要读取磁盘上某块数据
			 * 2、磁盘控制器把磁盘上指定的内容读取到内核缓冲区
			 * 3、内核把数据从内核缓冲区复制到用户缓冲区
			 * 这里内核缓冲区可以理解为操作系统层面的缓存，用户缓冲区可以理解为应用程序层面的缓存；内核缓冲区用的是堆外内存，用户缓冲区用的是堆内内存
			 */
			byte[] b = new byte[2];// 定义1k字节数组作为缓冲区
			while((j = in.read(b)) != -1) {// 一次性读入1k大小
				out.write(b, 0 ,j);// 一次性写出1k大小，这样每满1024字节会往磁盘写出一次，也就是和磁盘交互一次，如果文件恰好1k大小，那么写出时只和磁盘交互一次即可。
			}// 387518
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("总共耗时：" + (end - begin));
	}
}
