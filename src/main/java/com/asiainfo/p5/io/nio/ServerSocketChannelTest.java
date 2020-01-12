package com.asiainfo.p5.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 非阻塞socket服务端
 *
 * @author zhangzhiwang
 * @date Jan 11, 2020 6:15:47 PM
 */
public class ServerSocketChannelTest {
	public static void main(String[] args) {
		try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();) {
			serverSocketChannel.configureBlocking(false);// ServerSocketChannel默认在阻塞模式下运行，即默认是true，这里置为false就会使其在非阻塞模式下运行
			serverSocketChannel.socket().bind(new InetSocketAddress(8080));
			
			while(true) {
				System.out.println("等待建立连接...");
				SocketChannel socketChannel = serverSocketChannel.accept();// ServerSocketChannel默认是在阻塞模式下，所以当没有客户端建立连接时会阻塞在这里直到有客户端建立连接之后才继续往下运行。
																		   // 在非阻塞模式下如果没有客户端建立连接accept方法会立即返回socketChannel为null
				if(socketChannel == null) {
					System.out.println("\t尚没有客户端建立连接");
					Thread.sleep(1000);
					continue;
				}
				System.out.println("已有客户端建立连接！");
				
				// 接受客户端的数据
				ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
				socketChannel.read(byteBuffer);// read方法在read的过车个闹钟功能如果客户端突然关闭连接会报一个异常
				System.out.println("接收到客户端数据：" + new String(byteBuffer.array()));
				
				// 给客户端返回数据
				Thread.sleep(5000);
				ByteBuffer retByteBuffer = ByteBuffer.allocate(1024);
				retByteBuffer.put("return_0".getBytes());
				retByteBuffer.flip();
				socketChannel.write(byteBuffer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
