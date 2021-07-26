package com.asiainfo.service.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.asiainfo.service.api.RpcRequest;

public class SocketServerTest {
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		try(ServerSocket serverSocket = new ServerSocket(8081);) {
			while (true) {
				Socket socket = serverSocket.accept();
				executorService.execute(new SocketThread(socket, new HelloServiceImpl()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	static class SocketThread extends Thread {
		private Socket socket;
		private Object service;

		public SocketThread(Socket socket, Object service) {
			super();
			this.socket = socket;
			this.service = service;
		}

		public void run() {
			try(ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
				RpcRequest rpcRequest = (RpcRequest) in.readObject();
				Class<?> clazz = Class.forName(rpcRequest.getClassName());
				Method method = clazz.getMethod(rpcRequest.getMethodName(), rpcRequest.getArgTypes());
				Object result = method.invoke(service, rpcRequest.getArgs());

				out.writeObject(result);
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
}
