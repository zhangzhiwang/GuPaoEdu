package com.asiainfo.p5.io.nio;

import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 零拷贝客户端
 *
 * @author zhangzhiwang
 * @date Jan 13, 2020 10:13:36 AM
 */
public class ZeroCopyClient {
	public static void main(String[] args) {
		// 需求：客户端从磁盘读取一个文件通过网络发送到服务端，这个过程实现零拷贝
		try (SocketChannel socketChannel = SocketChannel.open();
				FileChannel fileChannel = FileChannel.open(Paths.get("/Users/zhangzhiwang/Downloads/q.mp4"), StandardOpenOption.READ);) {
			socketChannel.connect(new InetSocketAddress("localhost", 8080));// 这里采用默认的阻塞模式
			
			// 不使用用户空间，直接将内核空间的数据发送到网络
			long i = fileChannel.transferTo(0, fileChannel.size(), socketChannel);// 返回传输的字节个数
			System.out.println("传输总字节数：" + i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
