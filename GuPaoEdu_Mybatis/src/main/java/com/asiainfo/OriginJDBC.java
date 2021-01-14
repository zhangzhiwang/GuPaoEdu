package com.asiainfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.asiainfo.entity.User;

/**
 * 使用原始jdbc方式访问数据库
 * jdbc优点：使Java程序具有访问数据库的能力
 * jdbc缺点：
 * 1、有大量和业务无关的功能代码，而且这些代码都是相同的
 * 2、需要自己手动去处理结果集和实体类的映射
 * 3、需要手动去关闭资源，容易忘掉
 * 
 * @author zhangzhiwang
 * @date 2021年1月14日 下午12:47:56
 */
public class OriginJDBC {
	public static void main(String[] args) {
		// 1、引入相关依赖：需要引入和数据库相匹配的依赖，如果使用mysql则引入mysql-connector-java
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			// 2、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			// 3、获取Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "zzw1234");
			
			// 4、通过Connection获取PreparedStatement
			/**
			 * PreparedStatement和Statement区别：
			 * 1、PreparedStatement是Statement的子接口
			 * 2、PreparedStatement支持占位符“？”并提供了对占位符设置参数的方法set***，Statement不支持占位符，只能在sql中去拼接参数
			 * 3、PreparedStatement会对sql进行预编译，多次执行效率高于Statement，但是第一次执行的时候效率低于Statemen，所以适用于多次反复执行或者批量执行的场景下t；
			 *    Statement不会对sql进行预编译，适用于只执行一次
			 */
			prepareStatement = connection.prepareStatement("select * from t_user where id < ?");
			prepareStatement.setInt(1, 3);
			
			// 5、执行sql语句，如果是执行查询语句则需要使用executeQuery方法，写方法需要使用execute方法
			resultSet = prepareStatement.executeQuery();
			
			// 【可选】6、如果执行的是查询方法则需要对结果集ResultSet进行后续处理
			List<User> list = new ArrayList<>();
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				list.add(new User(id, name, age));
			}
			System.out.println(list);
			
			// 【可选】7、对于写方法，如果关闭了自动提交（默认是打开的）需要手动提交或回滚
			// connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6、按照打开的顺序倒序关闭
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
