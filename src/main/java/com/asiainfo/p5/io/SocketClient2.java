package com.asiainfo.p5.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * socket
 *
 * @author zhangzhiwang
 * @date Jan 7, 2020 5:35:24 PM
 */
public class SocketClient2 {
	public static void main(String[] args) {
		// socket通信中Socket类是作为通信的客户端，ServerSocket类作为通信的服务端，由Socket向ServerSocket发送消息
		try(Socket socket = new Socket("localhost", 8080);
				OutputStream outputStream = socket.getOutputStream();) {
			// 向服务端发送数据
			outputStream.write("client_2:Hello world!".getBytes());
			socket.shutdownOutput();
			
			// 接受服务端返回的数据
			InputStream inputStream = socket.getInputStream();
			int i = 0;
			byte[] buffer = new byte[10];
			System.out.println("客户端2接收服务端的响应：");
			while((i = inputStream.read(buffer)) != -1) {
				System.out.print(new String(buffer, 0, i));
			}
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
