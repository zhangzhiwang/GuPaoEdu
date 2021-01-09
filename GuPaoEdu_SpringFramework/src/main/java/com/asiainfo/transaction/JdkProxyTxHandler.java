package com.asiainfo.transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

import com.asiainfo.util.CommonUtil;

/**
 * 用jdk动态代理来实现事务
 *
 * @author zhangzhiwang
 * @date 2021年1月8日 下午11:07:58
 */
public class JdkProxyTxHandler implements InvocationHandler {
	private OriginalJdbc target = new OriginalJdbc();
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 执行目标方法之前开启事务
		System.out.println("开启事务");
		Connection connection = CommonUtil.getConnection();
		connection.setAutoCommit(false);
		
		Object result = null;
		try {
			// 执行目标方法，即service方法
			result = method.invoke(target, args);
			
			// 执行目标方法之后进行提交或者回滚
			connection.commit();
			System.out.println("事务已提交");
		} catch (Exception e) {
			System.out.println("事务已回滚");
			connection.close();
			e.printStackTrace();
		} finally {
			if(connection != null) {
				connection.close();
			}
		}
		
		return result;
	}
}
