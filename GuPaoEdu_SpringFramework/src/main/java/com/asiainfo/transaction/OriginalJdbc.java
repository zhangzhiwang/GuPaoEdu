package com.asiainfo.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.asiainfo.util.CommonUtil;

/**
 * 本示例代码用原始jdbc编程来模拟事务的本质
 * 第一部分模拟事务的开始，第二部分模拟事务的结束，第三部分模拟执行业务代码；本main方法可以看作是service层的代码，m1和m2方法可以看作是dao层的代码，整体可以看作service层在执行业务代码前做了一些事务的工作，然后执行了两个dao的方法，最后做了事务的收尾工作（提交或回滚）。
 * 那么第一部分和第二部分完全可以抽离出去做成切面，在执行main方法（service层的方法）之前织入，执行完成之后再织入。这也解释了为什么事务的控制要放到service层而不是dao层。
 * 
 * @author zhangzhiwang
 * @date 2021年1月8日 下午9:53:47
 */
public class OriginalJdbc implements IOriginalJdbcService{
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			// *************第1部分开始*************
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "zzw1234");
			connection.setAutoCommit(false);
			// *************第1部分结束*************

			// *************第3部分开始*************
			m1(connection, "aaa", 20);

//			int i = 1 / 0;

			m2(connection);
			// *************第3部分结束*************

			// *************第2部分开始*************
			connection.commit();
			System.out.println("成功");
		} catch (Exception e) {
			try {
				System.out.println("事务回滚");
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// *************第2部分结束*************
	}

	private static PreparedStatement m1(Connection connection, String name, int age) throws SQLException {
		PreparedStatement prepareStatement;
		prepareStatement = connection.prepareStatement("insert into t_user (name,age) values (?,?)");
		prepareStatement.setString(1, name);
		prepareStatement.setInt(2, age);
		prepareStatement.execute();
		return prepareStatement;
	}

	private static PreparedStatement m2(Connection connection) throws SQLException {
		PreparedStatement prepareStatement;
		prepareStatement = connection.prepareStatement("update t_user set age=age + 1 where id=1");
		prepareStatement.execute();
		return prepareStatement;
	}

	/**
	 * 模拟service方法调用两个dao方法
	 * 
	 * @param connection
	 * @throws SQLException
	 * @author zhangzhiwang
	 * @date 2021年1月8日 下午10:31:54
	 */
	public void serviceMethod(String name, int age) throws Exception {
		Connection connection = CommonUtil.getConnection();
		m1(connection, name, age);
		m2(connection);
	}
}