package com.asiainfo.p5.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 多路复用器（客户端）
 *
 * @author zhangzhiwang
 * @date 2020年1月12日 下午12:24:23
 */
public class SelectorClientTest {
	public static void main(String[] args) {
		try (Selector selector = Selector.open();
				SocketChannel socketChannel = SocketChannel.open();) {
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("localhost", 8080));
			socketChannel.register(selector, SelectionKey.OP_CONNECT);// 告诉selector本channel是在等待连接服务端
			
			while(true) {
				selector.select();
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectedKeys.iterator();
				while(iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					iterator.remove();
					SocketChannel channel = (SocketChannel) selectionKey.channel();
					if(selectionKey.isConnectable()) {// 表明该客户端已经和服务端建立了连接
						if(channel.isConnectionPending()) {
							channel.finishConnect();
						}
						channel.configureBlocking(false); 
						// 建立连接之后往服务端发数据
						ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
						byteBuffer.put("param_0".getBytes());
						byteBuffer.flip();
						channel.write(byteBuffer);
						
						// 向服务端发送请求之后接收服务端的返回
						// 等待客户端的返回又是一个阻塞操作，需要将该channel注册到selector上面
						channel.register(selector, SelectionKey.OP_READ);// 告诉selector本channel等待的是服务端的返回，所以是一个读取操作
					} else if(selectionKey.isReadable()) {
						ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
						channel.read(byteBuffer);// 这里一定收到了服务端的返回，因为是从selector返回的
						System.out.println("客户端收到了服务端的返回：" + new String(byteBuffer.array()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
