package com.asiainfo.p5.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 需求：将a目录下的文件复制到b目录下
 *
 * @author zhangzhiwang
 * @date Jan 2, 2020 7:28:52 PM
 */
public class FileCopyTest {
	public static void main(String[] args) throws InterruptedException, IOException {
		FileInputStream fileInputStream = new FileInputStream("/Users/zhangzhiwang/Pictures/表情图片.jpg");
		FileOutputStream fileOutputStream = new FileOutputStream("/Users/zhangzhiwang/Desktop/aa/test.jpg");
		try {
			int i = 0;
//			while ((i = fileInputStream.read()) != -1) {// 每次读一个字节
//				fileOutputStream.write(i);// 每读一个字节就立即写一个字节到磁盘，而且一次写一个字节。这样每写一个字节就有一次和磁盘的io交互
//			}
			
			// 上面的方式的缺点就是频繁地和磁盘进行io交互，下面是优化方案
			byte[] buffer = new byte[1024];// 建立一个1024字节的缓冲区
			while((i = fileInputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, i);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
