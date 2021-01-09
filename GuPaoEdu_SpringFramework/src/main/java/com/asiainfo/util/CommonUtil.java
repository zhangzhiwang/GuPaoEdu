package com.asiainfo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonUtil {
	public static int getNum() {
		return 100;
	}
	
	public static Connection getConnection() {// Connection做成单例
		return MyConnection.CONN;
	}
	
	static class MyConnection {
		private static Connection CONN = null;
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				CONN = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "zzw1234");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
