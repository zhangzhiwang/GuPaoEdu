package com.asiainfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.asiainfo.entity.User;

/**
 * 使用Spring JDBC访问数据库
 * 从原始的JDBC编程进化到Spring JDBC：
 * 优点：支持数据源，程序员不需要再关心资源的创建和释放了，由数据源来操作
 * 缺点：
 * 1、虽然提供了RowMapper接口，但是在mapRow()方法里还需要手工进行实体类的映射
 * 2、sql的参数仍然是按照顺序插入，而且占位符“？”过多的话容易混淆
 * 3、不支持数据库字段以及类型和Java实体类的属性和类型的自动映射
 * 4、不支持缓存
 * 所以需要从Spring JDBC进化到ORM框架
 * 
 * @author zhangzhiwang
 * @date 2021年1月14日 下午1:28:57
 */
public class SpringJDBC {
	public static void main(String[] args) {
		// 1、需要引入spring-jdbc依赖
		// 2、创建数据源
		DataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/test", "root", "zzw1234");

		// 3、创建JdbcTemplate对象
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// 4、使用JdbcTemplate对象执行相关的sql操作
		String sql = "select * from t_user where id < ?";
		List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				User user = new User(id, name, age);
				return user;
			}
		}, 3);
		
		System.out.println(userList);
	}
}
