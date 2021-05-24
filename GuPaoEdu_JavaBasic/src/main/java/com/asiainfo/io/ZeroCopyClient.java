package com.asiainfo.io;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * 零拷贝 需求：从磁盘读取文件并发送到网络中 本例是客户端
 *
 * @author zhangzhiwang
 * @date 2021年4月26日 下午2:54:11
 */
public class ZeroCopyClient {
	public static void main(String[] args) {
		try (FileChannel fileChannel = new FileInputStream("/Users/zhangzhiwang/Desktop/1.png").getChannel();// 从磁盘读取文件
				SocketChannel socketChannel = SocketChannel.open();
				) {
			socketChannel.connect(new InetSocketAddress("localhost", 8081));
			fileChannel.transferTo(0, fileChannel.size(), socketChannel);// 零拷贝（从磁盘内核空间转移到网络内核空间，不经过用户空间的拷贝），发送到网络
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}