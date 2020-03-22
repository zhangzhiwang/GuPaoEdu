package com.asiainfo.p6_2020.designPatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class MyConnectionFactory {
	private static Map<String, MyConnection> pool = new HashMap<String, MyConnection>();

	public static MyConnection getConnection(String connectName) {
		if (pool.get(connectName) != null) {
			System.out.println("使用缓存中的对象");
			return pool.get(connectName);
		}

		System.out.println("创建新对象");
		MyOracleConnection myOracleConnection = new MyOracleConnection();
		pool.put(connectName, myOracleConnection);
		return myOracleConnection;
	}
}
