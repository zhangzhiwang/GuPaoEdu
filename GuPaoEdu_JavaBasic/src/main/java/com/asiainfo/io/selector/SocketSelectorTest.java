package com.asiainfo.io.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 多路复用器——Selector，本例为客户端
 *
 * @author zhangzhiwang
 * @date 2021年4月26日 上午10:51:47
 */
public class SocketSelectorTest {
	private static Selector selector;

	public static void main(String[] args) {
		try (SocketChannel socketChannel = SocketChannel.open();) {
			selector = Selector.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("localhost", 8081));
			socketChannel.register(selector, SelectionKey.OP_CONNECT);// 客户端注册到Selector上时使用的是OP_CONNECT模式，因为只有客户端才需要connect到服务端

			while (true) {
				selector.select();
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectedKeys.iterator();
				while (iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					iterator.remove();
					if (selectionKey.isConnectable()) {// 如果是可连接模式，那么连接上之后肯定要往服务端发数据
						dealConnectable(selectionKey);
					} else if (selectionKey.isReadable()) {
						dealReadable(selectionKey);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void dealReadable(SelectionKey selectionKey) {
		try {
			SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			socketChannel.read(byteBuffer);
			System.out.println("---客户端接收到的消息：" + byteBuffer.array());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void dealConnectable(SelectionKey selectionKey) {
		try {
			SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
			socketChannel.configureBlocking(false);
//			if(socketChannel.isConnectionPending()) {// 在不使用Selector且非阻塞模式下，需要调用isConnectionPending()来判断是否连接成功，但这里既然Selector把该channel已经select出来说明肯定是连接成功的了
			socketChannel.finishConnect();
//			}

			socketChannel.write(ByteBuffer.wrap("client send param : {}".getBytes()));// 手动往ByteBuffer写数据有两个方法：byteBuffer.put(byte[] src)和ByteBuffer.wrap(byte[] array)
			socketChannel.register(selector, SelectionKey.OP_READ);// 这里要把socketChannel注册到Selector上，而且是模式是OP_READ（读模式），这样服务端可以接收该客户端传的数据
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
