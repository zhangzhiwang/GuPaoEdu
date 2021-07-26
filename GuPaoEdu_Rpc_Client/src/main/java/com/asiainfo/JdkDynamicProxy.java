package com.asiainfo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

import com.asiainfo.service.api.RpcRequest;

/**
 * jdk动态代理</br>
 * 本动态代理和正常的jdk动态代理不一样，正常的要给本类传入接口具体的实现类对象target作为invoke方法中method调用的主题对象，</br>
 * 而在本例中由于是rpc远程通信，client端只有接口类没有实现类，所以原本的target要被socket取代。
 *
 * @author zhangzhiwang
 * @date 2021年4月22日 上午10:23:38
 */
public class JdkDynamicProxy implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		ObjectInputStream in = null;
		try (Socket socket = new Socket("localhost", 8081); // 可以写在配置文件里
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				) {
			
			RpcRequest rpcRequest = new RpcRequest();
			rpcRequest.setClassName(method.getDeclaringClass().getName());
			rpcRequest.setMethodName(method.getName());
			rpcRequest.setArgs(args);
			rpcRequest.setArgTypes(method.getParameterTypes());
			
			out.writeObject(rpcRequest);
			out.flush();
			
			in = new ObjectInputStream(socket.getInputStream());
			result = in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}

		return result;
	}

}
