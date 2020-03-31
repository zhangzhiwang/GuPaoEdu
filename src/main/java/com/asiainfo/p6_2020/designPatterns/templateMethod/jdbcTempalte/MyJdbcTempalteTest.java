package com.asiainfo.p6_2020.designPatterns.templateMethod.jdbcTempalte;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class MyJdbcTempalteTest {
	private static DataSource dataSource;// 假设dataSource已经被注入进来
	
	public static void main(String[] args) {
		DaoImpl daoImpl = new DaoImpl(null);
		daoImpl.getAllStudent();
		
		/**
		 * 模板方法模式在org.springframework.jdbc.core.JdbcTemplate中的应用：</p>
		 * 可参考：https://www.ucloud.cn/yun/6899.html
		 */
		
		// spring jdbc编程的伪码：
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);// 假设dataSource已经被注入进来
		jdbcTemplate.execute("select * from table");// 打开源码，模板方法模式就在execute方法里面调用的execute方法里面，这里面封装了jdbc编程的步骤
	}
}
