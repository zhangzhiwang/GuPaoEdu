package com.asiainfo.p5.redis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 自定义Redis客户端
 *
 * @author zhangzhiwang
 * @date Sep 22, 2020 10:44:43 PM
 */
public class MyRedisClient {
	private Socket socket;
	
	public MyRedisClient(String host, int port) {
		try {
			socket = new Socket(host, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String set(String key, String value) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("*3");// 代表set命令有三个操作数，分别是：“set”、“key”和“value”
		stringBuilder.append("\r\n");
		stringBuilder.append("$3");// 第一个操作数的长度，第一个操作数是“set”
		stringBuilder.append("\r\n");
		stringBuilder.append("set");// 第一个操作数的内容
		stringBuilder.append("\r\n");
		
		stringBuilder.append("$").append(key.getBytes().length);// 第二个操作数的长度，也就是key的长度
		stringBuilder.append("\r\n");
		stringBuilder.append(key);// 第二个操作数的内容
		stringBuilder.append("\r\n");
		
		stringBuilder.append("$").append(value.getBytes().length);// 第三个操作数的长度，也就是value的长度
		stringBuilder.append("\r\n");
		stringBuilder.append(value);// 第三个操作数的内容
		stringBuilder.append("\r\n");
		
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(stringBuilder.toString().getBytes());
		
		byte[] bs = new byte[1024];
		InputStream inputStream = socket.getInputStream();
		inputStream.read(bs);
		return new String(bs);
	}
	
	public String get(String key) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("*2");// 代表get命令有两个操作数，分别是：“get”、“key”
		stringBuilder.append("\r\n");
		stringBuilder.append("$3");// 第一个操作数的长度，第一个操作数是“get”
		stringBuilder.append("\r\n");
		stringBuilder.append("get");// 第一个操作数的内容
		stringBuilder.append("\r\n");
		
		stringBuilder.append("$").append(key.getBytes().length);// 第二个操作数的长度，也就是key的长度
		stringBuilder.append("\r\n");
		stringBuilder.append(key);// 第二个操作数的内容
		stringBuilder.append("\r\n");
		
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(stringBuilder.toString().getBytes());
		
		byte[] bs = new byte[1024];
		InputStream inputStream = socket.getInputStream();
		inputStream.read(bs);
		return new String(bs);
	}
	
	public static void main(String[] args) throws IOException {
		MyRedisClient myRedisClient = new MyRedisClient("localhost", 6379);
		String setResult = myRedisClient.set("s1", "1999");
		System.out.println("setResult = " + setResult);
		
		System.out.println("---------------");
		
		String getResult = myRedisClient.get("s1");
		System.out.println("getResult = " + getResult);
	}
}
