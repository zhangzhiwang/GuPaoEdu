package com.asiainfo.io;

import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 零拷贝，本例是服务端
 *
 * @author zhangzhiwang
 * @date 2021年4月26日 下午3:01:01
 */
public class ZeroCopyServer {
	public static void main(String[] args) {
		try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
				FileChannel fileChannel = new FileOutputStream("/Users/zhangzhiwang/Desktop/1_2.png").getChannel();
				) {
			serverSocketChannel.bind(new InetSocketAddress(8081));
			SocketChannel socketChannel = serverSocketChannel.accept();
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			
			while(socketChannel.read(byteBuffer) != -1) {
				byteBuffer.flip();
				fileChannel.write(byteBuffer);
				byteBuffer.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
