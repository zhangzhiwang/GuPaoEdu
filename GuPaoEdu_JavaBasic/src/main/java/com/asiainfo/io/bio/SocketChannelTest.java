package com.asiainfo.io.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 基于NIO非阻塞的socket客户端
 *
 * @author zhangzhiwang
 * @date 2021年4月23日 下午1:31:37
 */
public class SocketChannelTest {
	public static void main(String[] args) {
		try {
			SocketChannel socketChannel = SocketChannel.open();
			/**
			 * 如果服务端没有启动而直接启动客户端，那么connect方法：
			 * 在阻塞模式下：直接抛异常：java.net.ConnectException: Connection refused
			 * 在非阻塞模式下：直接抛异常：java.nio.channels.NotYetConnectedException
			 * 如果在非阻塞模式下连接上了服务端，那么要调用finishConnect方法
			 */
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("localhost", 8081));
			if(socketChannel.isConnectionPending()) {
				socketChannel.finishConnect();
			} else {
				System.out.println("没有连接上服务端");
			}
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.put("hello".getBytes());
			buffer.flip();
//			Thread.sleep(20000);
			socketChannel.write(buffer);
			
			buffer.clear();
			socketChannel.read(buffer);// 在非阻塞模式下，read不会进行阻塞，在未接收到服务端信息的时候直接返回，但奇怪的是服务端在非阻塞模式下read仍然为阻塞状态
			System.out.println("收到服务端返回：" + new String(buffer.array()));
			
//			Thread.sleep(100000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
