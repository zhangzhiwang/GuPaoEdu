package com.asiainfo.p5.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket
 *
 * @author zhangzhiwang
 * @date Jan 7, 2020 5:35:24 PM
 */
public class MySocketServer extends Thread {
	private Socket socket;

	private MySocketServer(Socket socket) {
		super();
		this.socket = socket;
	}

	public static void main(String[] args) {
		try {
			// socket通信中Socket类是作为通信的客户端，ServerSocket类作为通信的服务端，由Socket向ServerSocket发送消息
			ServerSocket serverSocket = new ServerSocket(8080);
			Socket socket = serverSocket.accept();// ServerSocket服务端接受请求并返回一个Socket客户端，如果没有Socket客户端发送请求就会阻塞，直到有请求过来

			MySocketServer mySocketServer = new MySocketServer(socket);
			mySocketServer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void run() {
		met1(socket);
	}

	public void met1(Socket socket) {
		try {
			while (true) {
				InputStream inputStream = socket.getInputStream();// 如果有请求过来但是没有发送数据也会阻塞，直到有数据发送过来
				int i = 0;
				byte[] buffer = new byte[10];
				while ((i = inputStream.read(buffer)) != -1) {
					System.out.print(new String(buffer, 0, i));
				}
				System.out.println("接受完毕！");

				Thread.sleep(10000);
				// 返回数据给客户端
				OutputStream outputStream = socket.getOutputStream();
				outputStream.write("MySocketServer返回数据".getBytes());
				socket.shutdownOutput();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
