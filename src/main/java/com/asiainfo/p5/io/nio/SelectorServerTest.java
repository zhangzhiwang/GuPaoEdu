package com.asiainfo.p5.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

/**
 * 多路复用器（服务端）
 * </p>
 * 在非阻塞模式下，将所有的channel注册到一个“注册中心”，这个注册中心负责轮询所有注册在这里的channel，一旦有channel准备就绪就返回，这个“注册中心”就是多路复用器Selector
 *
 * @author zhangzhiwang
 * @date 2020年1月12日 下午12:25:42
 */
public class SelectorServerTest {
	public static void main(String[] args) {
		try (
				// 建立一个多路复用器Selector。注意：Selector.open()返回的不是一个单例Selector对象，也就是说服务端和客户端是不同的多路复用器
				Selector selector = Selector.open();
				ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();) {
			serverSocketChannel.configureBlocking(false);// 这里必须设置为非阻塞模式，否则Selector就没有什么用了
			serverSocketChannel.bind(new InetSocketAddress(8080));
			// 将该channel注册到selector上面，并标识为等待请求（ACCEPT），表示该channel正在等待连接请求。注册后selector会返回一个唯一的key作为该channel在“注册中心”的唯一标识，通过该标识可以关联到已注册的channel
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			while (true) {
				selector.select();// 此方法会阻塞，可以把整个while循环放到一个单独的线程里面
				Set<SelectionKey> readyKeys = selector.selectedKeys();// selector会轮询监听已注册的所有channel，一旦某些channel已就绪selector就会将其返回
				Iterator<SelectionKey> iterator = readyKeys.iterator();
				while (iterator.hasNext()) {
					SelectionKey readyKey = iterator.next();
					iterator.remove();
					SelectableChannel channel = readyKey.channel();// 通过SelectionKey获取与之关联的channel
					// 判断SelectionKey的类型
					if (readyKey.isAcceptable()) {// 这个SelectionKey所对应的channel是用来接收连接请求的
						ServerSocketChannel ssc = (ServerSocketChannel) channel;
						SocketChannel socketChannel = ssc.accept();// 这里一定不会阻塞，因为是selector返回的，只要是返回的就一定是已经准备好了的
						// 服务端接受到客户端的请求之后准备读取客户端传来的数据，但是读取操作也是一个阻塞操作，即使在非阻塞模式下如果客户端还没有传来数据服务端就继续放下运行也没有什么意义，除非服务端自己轮询价差客户端是否有数据传过来
						// 所以，这里在接收到客户端的连接后将socketChannel注册到selector中用于在客户端数据到来的时候返回
						socketChannel.configureBlocking(false);
						socketChannel.register(selector, SelectionKey.OP_READ);// 这里是read模式，就是告诉selector本channel是用来等待客户端的数据流而不是等待客户端的连接
					} else if (readyKey.isReadable()) {// 这个SelectionKey所对应的channel是用来接收客户端数据流的
						SocketChannel socketChannel = (SocketChannel) channel;
						ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
						socketChannel.read(byteBuffer);
						System.out.println("服务端收到客户端的请求：" + new String(byteBuffer.array()));

						Thread.sleep(1000);
//						// 服务端向客户端返回数据
						byteBuffer.flip();
						socketChannel.write(byteBuffer);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
