package com.asiainfo.p5.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 非阻塞socket客户端
 *
 * @author zhangzhiwang
 * @date Jan 11, 2020 6:17:34 PM
 */
public class SocketChannelTest {
	public static void main(String[] args) {
		try (SocketChannel socketChannel = SocketChannel.open();) {
			// SocketChannel和ServerSocketChannel都有两种模式：阻塞和非阻塞
			// 无论是非阻塞的socket客户端还是非阻塞的socket服务端默认都是阻塞模式，如果要想在非阻塞模式下运行需要进行设置
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("localhost", 8080));// 在阻塞模式下只有socketli连接建立成功之后才会往下继续运行，否则会阻塞在建立连接这一步。
																			// 在非阻塞模式下无论是否连接建立成功都会继续往下运行，但是如果连接尚未建立成功的话那么在进行SocketChannel其他操作时会报出异常java.nio.channels.NotYetConnectedException
			if (socketChannel.isConnectionPending()) {// 在非阻塞模式下要先判断是否连接已经建立成功再往下操作
				socketChannel.finishConnect();
			}
			System.out.println("连接已建立！");
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			byteBuffer.put("Hello World!".getBytes());
			byteBuffer.flip();// ByteBuffer由读模式转化为写模式
			socketChannel.write(byteBuffer);

			// 接受服务端的相应
			ByteBuffer retByteBuffer = ByteBuffer.allocate(1024);
			byteBuffer.clear();
			int read = socketChannel.read(byteBuffer);// 在默认的阻塞模式下客户端会阻塞在这里直到接收到服务端的返回
			if(read <= 0) {
				System.out.println("未收到客户端返回数据！");
			} else {
				System.out.println("收到服务端的消息：" + new String(byteBuffer.array()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
