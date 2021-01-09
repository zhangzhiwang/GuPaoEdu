package com.asiainfo.transaction;

import java.lang.reflect.Proxy;

/**
 * 用jdk动态代理来实现事务
 *
 * @author zhangzhiwang
 * @date 2021年1月8日 下午10:27:25
 */
public class JdkProxyTx {
	public static void main(String[] args) throws Exception {
		IOriginalJdbcService proxy = (IOriginalJdbcService) Proxy.newProxyInstance(OriginalJdbc.class.getClassLoader(), OriginalJdbc.class.getInterfaces(), new JdkProxyTxHandler());
		proxy.serviceMethod("bbb", 21);
	}
}
