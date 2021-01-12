package com.asiainfo.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.asiainfo.util.CommonUtil;

@Repository
public class Dao2 {
	public void met2() {
		try {
			Connection connection = CommonUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("update t_user set age=age + 1 where id=1");
			int i = 1 / 0;
			prepareStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
