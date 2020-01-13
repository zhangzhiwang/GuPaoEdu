package com.asiainfo.p5.io.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 零拷贝服务端
 *
 * @author zhangzhiwang
 * @date Jan 13, 2020 10:30:11 AM
 */
public class ZeroCopyServer {
	public static void main(String[] args) {
		try (
				ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
				FileChannel fileChannel = FileChannel.open(Paths.get("/Users/zhangzhiwang/Desktop/q.mp4"), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
			serverSocketChannel.socket().bind(new InetSocketAddress(8080));
			SocketChannel socketChannel = serverSocketChannel.accept();// 采用阻塞模式
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			int i = 0;
			while((i = socketChannel.read(byteBuffer)) != -1) {
				byteBuffer.flip();
				fileChannel.write(byteBuffer);
				byteBuffer.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
