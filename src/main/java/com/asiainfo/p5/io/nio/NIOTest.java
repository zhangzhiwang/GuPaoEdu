package com.asiainfo.p5.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO
 *
 * @author zhangzhiwang
 * @date Jan 10, 2020 7:28:51 PM
 */
public class NIOTest {
	public static void main(String[] args) {
		try (FileInputStream fileInputStream = new FileInputStream("/Users/zhangzhiwang/Downloads/QQ20191226-120140-HD.mp4");
				FileOutputStream fileOutputStream = new FileOutputStream("/Users/zhangzhiwang/Desktop/QQ20191226-120140-HD.mp4");
				// 创建管道
				FileChannel inChannel = fileInputStream.getChannel();
				FileChannel outChannel = fileOutputStream.getChannel();
				) {

			// 初始化缓冲区
			// 方式1:
			ByteBuffer buffer = ByteBuffer.allocate(10);
//			// 方式2:
//			ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[10]);
			
			int i = 0;
			while((i = inChannel.read(buffer)) != -1) {// 读取数据到缓冲区，返回读取字节的个数，上限是缓冲数组的长度，即最多读取缓冲数组长度个字节
				buffer.flip();// 从读转化为写
				outChannel.write(buffer);
				buffer.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
