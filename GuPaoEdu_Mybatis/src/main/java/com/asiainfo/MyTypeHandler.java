package com.asiainfo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * 自定义类型映射器
 *
 * @author zhangzhiwang
 * @date 2021年1月14日 下午11:40:00
 */
public class MyTypeHandler implements TypeHandler<String> {

	/**
	 *	set开头的方法是从Java类到字段类型的映射
	 */
	@Override
	public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, "【" + parameter + "】");
	}

	/**
	 * get开头的方法是从字段类型到Java类型的映射
	 */
	@Override
	public String getResult(ResultSet rs, String columnName) throws SQLException {
		String result = rs.getString(columnName);
		return "{" + result + "}";
	}

	@Override
	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		String result = rs.getString(columnIndex);
		return "{" + result + "}";
	}

	@Override
	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return null;
	}
}
