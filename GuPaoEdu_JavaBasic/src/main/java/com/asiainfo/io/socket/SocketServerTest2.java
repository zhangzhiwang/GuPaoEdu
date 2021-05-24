package com.asiainfo.io.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * socket服务端多线程优化</br>
 * 本示例是bio模型，会阻塞哎两个地方：</br>
 * 一个是serverSocket.accept()这里，等待客户端连接会阻塞，直到有客户端连接过来才会被唤醒；</br>
 * 一个是socket.getInputStream()这里，等待客户端的输入信息，如果客户端发送的信息没有传输完成，那么会一直阻塞在这里。</br>
 * 本示例还有一个弊端就是一个socket服务端进程同一时间只能响应一个客户端的连接，等处理完上一个客户端的连接之后才能响应下一个客户端的连接请求，这样就大大降低了并发性。</br>
 * 为了提高并发行，对这种bio模型做多线程的优化：将每一个客户端的请求都抛给一个线程来处理，这样就不会因为阻塞而导致不能响应其他客户端的请求。</br>
 *
 * @author zhangzhiwang
 * @date 2021年4月15日 下午8:42:57
 */
public class SocketServerTest2 {
	private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8081);
			while (true) {
				Socket socket = serverSocket.accept();
				new SocketThread(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	static class SocketThread extends Thread {
		private Socket socket;

		public SocketThread(Socket socket) {
			super();
			this.socket = socket;
		}

		public void run() {
			try (InputStream inputStream = socket.getInputStream(); BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)); OutputStream outputStream = socket.getOutputStream(); BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));) {

				String line = bufferedReader.readLine();
				System.out.println("接收到客户端发送的消息：" + line);

				Thread.sleep(20000);

				bufferedWriter.write("我已接收到你的消息");
				bufferedWriter.flush();
				System.out.println("已发送返回消息");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
