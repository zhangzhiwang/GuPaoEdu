package com.asiainfo.p5.io;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket
 *
 * @author zhangzhiwang
 * @date Jan 7, 2020 5:35:24 PM
 */
public class MySocketServer {
	public static void main(String[] args) {
		// socket通信中Socket类是作为通信的客户端，ServerSocket类作为通信的服务端，由Socket向ServerSocket发送消息
		try(ServerSocket serverSocket = new ServerSocket(8080)
				) {
			Socket socket = serverSocket.accept();// ServerSocket服务端接受请求并返回一个Socket客户端，如果没有Socket客户端发送请求就会阻塞，直到有请求过来
			InputStream inputStream = socket.getInputStream();// 如果有请求过来但是没有发送数据也会阻塞，直到有数据发送过来
			int i = 0;
			byte[] buffer = new byte[10];
			while((i = inputStream.read(buffer)) != -1) {
				System.out.print(new String(buffer, 0, i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
