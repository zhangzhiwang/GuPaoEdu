package com.asiainfo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.asiainfo.aop.MyAnnotation1;
import com.asiainfo.aop.MyAnnotation2;
import com.asiainfo.dao.IUserDao;
import com.asiainfo.entity.Cat;
import com.asiainfo.entity.Cat2;
import com.asiainfo.entity.Cat3;
import com.asiainfo.entity.User;
import com.asiainfo.entity.User3;

@Repository
//@Controller
@MyAnnotation1
public class UserDaoImpl implements IUserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;// JdbcTemplate的好用程度介于原声jdbc和orm框架之间
	
	@Override
	public User3 queryUser() {
		return new User3("查询结果", -1);
	}
	
	public void test1(String s) {
		System.out.println("UserDaoImpl.test1");
	}
	
	public void m5(Cat cat, Cat2 cat2, Cat3 cat3) {
		System.out.println("UserDaoImpl.m5");
	}
	
	public void m4() {
		System.out.println("UserDaoImpl.m4");
	}
	
	@MyAnnotation2
	public void m6() {
		System.out.println("UserDaoImpl.m6");
	}

	@Override
	public void insertUser(User user) {
		jdbcTemplate.update("insert into t_user (name,age) values (?,?)", user.getName(), user.getAge());
	}

	@Override
	public List<User> queryAllUsers() {
		List<User> userLst = jdbcTemplate.query("select * from t_user", new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {// 手动映射结果集和实体类属性的关系
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				return user;
			}
		});
		
		return userLst;
	}
}
