package com.asiainfo.io.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * socket客户端2
 * 模拟两个客户端并发对server进行请求
 *
 * @author zhangzhiwang
 * @date 2021年4月15日 下午8:42:31
 */
public class SocketClientTest2 {
	public static void main(String[] args) {
		try(Socket socket = new Socket("localhost", 8081);
				OutputStream outputStream = socket.getOutputStream();
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
				InputStream inputStream = socket.getInputStream();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				) {
			bufferedWriter.write("入參：{2}\n");
			bufferedWriter.flush();
			
			String line = bufferedReader.readLine();
			System.out.println("接收服务端的消息：" + line);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
