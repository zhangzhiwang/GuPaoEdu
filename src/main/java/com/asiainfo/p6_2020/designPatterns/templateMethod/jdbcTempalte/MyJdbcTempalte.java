package com.asiainfo.p6_2020.designPatterns.templateMethod.jdbcTempalte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public abstract class MyJdbcTempalte {
	private DataSource dataSource;

	public MyJdbcTempalte(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public final <T> List<T> executeQuery(String sql, MyRowMapper<T> myRowMapper) {// 抽象类定义了查询数据的所有步骤及顺序，子类不能修改，所以是final的。子类可以决定某些步骤的具体实现方式，比如step4
		List<T> list = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// step1:获取数据库连接
			conn = getConnection(dataSource);
			// step2:获取语句集
			ps = getPreparedStatement(conn, sql);
			// step3:执行语句并获取结果集
			rs = executeQuery(ps, sql);
			// step4:处理结果集
			list = dealResultSet(rs, myRowMapper);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// step5:各种关闭
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	private <T> List<T> dealResultSet(ResultSet rs, MyRowMapper<T> myRowMapper) throws SQLException {
		List<T> list = new ArrayList<T>();
		int rowNum = 0;
		while (rs.next()) {
			list.add(myRowMapper.mapRow(rs, rowNum++));
		}
		return list;
	}

	private ResultSet executeQuery(PreparedStatement ps, String sql) throws SQLException {
		// TODO Auto-generated method stub
		return ps.executeQuery(sql);
	}

	private PreparedStatement getPreparedStatement(Connection conn, String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}

	private Connection getConnection(DataSource dataSource) throws SQLException {
		return dataSource.getConnection();
	}
}
