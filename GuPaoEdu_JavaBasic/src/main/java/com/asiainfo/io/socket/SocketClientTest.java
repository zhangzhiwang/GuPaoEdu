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
 * socket客户端
 *
 * @author zhangzhiwang
 * @date 2021年4月15日 下午8:42:31
 */
public class SocketClientTest {
//	public static void main(String[] args) {
//		try(Socket socket = new Socket("localhost", 8081);// Socket类作为客户端
//				OutputStream out = socket.getOutputStream();
//				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
//				InputStream in = socket.getInputStream();
//				InputStreamReader inputStreamReader = new InputStreamReader(in);
//				) {
//			outputStreamWriter.write("Hello World!\n");
//			outputStreamWriter.flush();
//			
//			int i = 0;
////			byte[] b = new byte[3];
//			char[] c = new char[3];
//			System.out.println("收到服务端的消息：");
//			while((i = inputStreamReader.read(c)) != -1) {
//				System.out.print(new String(c, 0, i));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
//		InputStream inputStream = null;
//		BufferedReader bufferedReader = null;
		try(Socket socket = new Socket("localhost", 8081);
				OutputStream outputStream = socket.getOutputStream();
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
				InputStream inputStream = socket.getInputStream();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				) {
			bufferedWriter.write("入參：{1}\n");
			bufferedWriter.flush();
			
			String line = bufferedReader.readLine();
			System.out.println("接收服务端的消息：" + line);
		} catch (Exception e) {
			e.printStackTrace();
		} 
//		finally {
//			if(bufferedReader != null) {
//				try {
//					bufferedReader.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			
//			if(inputStream != null) {
//				try {
//					inputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
}
