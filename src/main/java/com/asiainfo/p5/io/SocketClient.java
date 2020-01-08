package com.asiainfo.p5.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * socket
 *
 * @author zhangzhiwang
 * @date Jan 7, 2020 5:35:24 PM
 */
public class SocketClient {
	public static void main(String[] args) {
		// socket通信中Socket类是作为通信的客户端，ServerSocket类作为通信的服务端，由Socket向ServerSocket发送消息
		try(Socket socket = new Socket("localhost", 8080);
				OutputStream outputStream = socket.getOutputStream();) {
			
			outputStream.write("Hello world!".getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
