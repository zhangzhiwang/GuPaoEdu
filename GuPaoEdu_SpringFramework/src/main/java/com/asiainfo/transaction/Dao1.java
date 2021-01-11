package com.asiainfo.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.asiainfo.util.CommonUtil;

@Repository
public class Dao1 {
	public void met1() throws SQLException {
		Connection connection = CommonUtil.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("insert into t_user (name,age) values (?,?)");
		prepareStatement.setString(1, "zs");
		prepareStatement.setInt(2, 18);
		prepareStatement.execute();
	}
}
