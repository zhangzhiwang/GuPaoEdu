package com.asiainfo.io.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 基于磁盘的channel使用FileChannel，基于网络的channel使用ServerSocketChannel
 *
 * @author zhangzhiwang
 * @date 2021年4月23日 下午1:25:24
 */
public class ServerSocketChannelTest {
	public static void main(String[] args) {
		try(ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();) {
			serverSocketChannel.socket().bind(new InetSocketAddress(8081));// 绑定监控的端口
			/**
			 * 默认是true。默认情况下NIO模式的Socket（包括客户端和服务端）仍然在accept方法和read方法的地方进行阻塞。
			 * 将configureBlocking方法传入false，即进入非阻塞模式。
			 * NIO的Socket支持两种模式：阻塞（默认）模式和非阻塞模式。
			 */
			serverSocketChannel.configureBlocking(false);// 服务端设置为非阻塞模式貌似只对accept()方法起作用，对read()方法貌似不起作用，仍然为阻塞
			while(true) {
				SocketChannel socketChannel = serverSocketChannel.accept();// 在非阻塞模式下，如果没有客户端连接过来那么socketChannel返回null
				if(socketChannel == null) {
					System.out.println("尚未有客户端进行连接");
					Thread.sleep(1000);
					continue;
				}
//				System.out.println("虽然是NIO但accept()方法仍然是阻塞的（默认情况下）");
				System.out.println("已有客户端连接");
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				socketChannel.read(buffer);
//				System.out.println("虽然是NIO但read()方法仍然是阻塞的（默认情况下）");
				System.out.println("客户端传入：" + new String(buffer.array()));
				
				Thread.sleep(10000);
				buffer = ByteBuffer.allocate(1024);
				buffer.put("服务端返回信息".getBytes());
				buffer.flip();
				socketChannel.write(buffer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
