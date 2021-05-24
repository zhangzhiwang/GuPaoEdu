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

/**
 * socket服务端
 *
 * @author zhangzhiwang
 * @date 2021年4月15日 下午8:42:57
 */
public class SocketServerTest {
//	public static void main(String[] args) {
//		try (ServerSocket serverSocket = new ServerSocket(8081); // 向操作系统申请要暴露的接口
//				Socket socket = serverSocket.accept();// 当接收到socket客户端连接过来时会创建一个socket对象，且此方法是阻塞的，如果一直没有客户端连接过来会一直阻塞
//				InputStream in = socket.getInputStream();// 获取客户端传输过来的信息，该方法也会阻塞。注意：在客户端发送消息时，在消息的末尾要加上“\n”，告诉服务端消息内容的结束，否则服务端会以为客户端消息还没有发送完会一直阻塞
//				InputStreamReader inputStreamReader = new InputStreamReader(in);
//				// socket是基于tcp连接的，tcp是双工通信，即双向通信
//				// 服务端向客户端发送消息
//				OutputStream out = socket.getOutputStream();
//				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
//		) {
////			int i = 0;
////			byte[] b = new byte[1024];
////			char[] c = new char[3];
////			System.out.println("接收到客户端发送的消息：");
////			while ((i = inputStreamReader.read(c)) != -1) {
////				System.out.print(new String(c, 0, i));
////			}
//
//			System.out.println("即将发送响应信息...");
//			outputStreamWriter.write("我已收到你的信息\n");
//			outputStreamWriter.flush();
//			System.out.println("发送响应信息完成");
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
//	}
	
	public static void main(String[] args) {
//		OutputStream outputStream = null;
//		BufferedWriter bufferedWriter = null;
		try(ServerSocket serverSocket = new ServerSocket(8081);
				Socket socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				OutputStream outputStream = socket.getOutputStream();
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
				) {
			String line = bufferedReader.readLine();
			System.out.println("接收到客户端发送的消息：" + line);
			
			bufferedWriter.write("我已接收到你的消息");
			bufferedWriter.flush();
			System.out.println("已发送返回消息");
		} catch (IOException e) {
			e.printStackTrace();
		} 
//		finally {
//			if(bufferedWriter != null) {
//				try {
//					bufferedWriter.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			
//			if(outputStream != null) {
//				try {
//					outputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
}
