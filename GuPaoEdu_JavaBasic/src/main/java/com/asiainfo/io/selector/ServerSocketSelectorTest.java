package com.asiainfo.io.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 多路复用器——Selector，本例为服务端
 *
 * @author zhangzhiwang
 * @date 2021年4月25日 下午2:13:50
 */
public class ServerSocketSelectorTest {
	private static Selector selector = null;

//	static {
//		try {
//			selector = Selector.open();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) {
		try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();) {
			selector = Selector.open();// 服务端和客户端都调用open方法来获得Selector实例，怎么保证在不同进程下Selector的实例是同一个呢？？？
			serverSocketChannel.configureBlocking(false);// 要使用Selector必须设置为非阻塞模式。所以Selector不适合FileChannel，因为FileChannel不能切换为非阻塞模式
			serverSocketChannel.socket().bind(new InetSocketAddress(8081));
			// 将ServerSocketChannel注册到Selector上
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);// SelectionKey有四种模式（进入源码可以查看到），这里注册的是服务端用于接受客户端的连接所以用OP_ACCEPT
			while (true) {
				selector.select();// 此方法的所用是：Selector会不断轮询所有注册到自己身上的channel，直到至少一个channel连接准备好之后返回可用的channel，此方法在返回前会阻塞
				Set<SelectionKey> selectedKeys = selector.selectedKeys();// 每一个注册到Selector上的channel（无论客户端还是服务端）又会有一个唯一标识，这个唯一标识用SelectionKey来表示，一个SelectionKey对应一个Channel
				Iterator<SelectionKey> iterator = selectedKeys.iterator();
				while (iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					iterator.remove();// 主要这里要从所有已准备好的channel集合中移除掉，以免外层while循环下一次循环到这里的时候该SelectionKey所对应的channel还在已准备好的集合里面，从而导致重复处理
					if (selectionKey.isAcceptable()) {// 如果是可接收模式，说明selectionKey对应的channel是服务端ServerSocketChannel，因为只有ServerSocketChannel才能accept
						dealAcceptable(selectionKey);
					} else if (selectionKey.isReadable()) {// 如果是可读模式，那么说明要读取另一个channel发送的数据，selectionKey对应的channel是客户端SocketChannel，因为只有SocketChannel才能read
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
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);// 假设消息小于1k，如果大于1k这里需要循环读取
			socketChannel.read(byteBuffer);
			System.out.println("服务端收到的消息是：" + new String(byteBuffer.array()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void dealAcceptable(SelectionKey selectionKey) {
		try (ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();) {
			serverSocketChannel.configureBlocking(false);
			SocketChannel socketChannel = serverSocketChannel.accept();// 注意：这里的socketChannel一定不为null，因为selector既然能把它select出来说明连接已经建立否则也不可能把它select出来
			socketChannel.configureBlocking(false);
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);// 假设消息小于1k，如果大于1k这里需要循环写入
			byteBuffer.put("server return {}".getBytes());
			byteBuffer.flip();
			socketChannel.write(byteBuffer);
			socketChannel.register(selector, SelectionKey.OP_READ);// 这里要把socketChannel注册到Selector上，而且是模式是OP_READ（读模式），这样客户端可以接收该服务端传的数据
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
