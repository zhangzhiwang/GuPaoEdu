package com.asiainfo.p6_2020.designPatterns.templateMethod.jdbcTempalte;

public class MyJdbcTempalteTest {
	public static void main(String[] args) {
		DaoImpl daoImpl = new DaoImpl(null);
		daoImpl.getAllStudent();
		
		/**
		 * 模板方法模式在org.springframework.jdbc.core.JdbcTemplate中的应用：</p>
		 * 可参考：https://www.ucloud.cn/yun/6899.html
		 */
	}
}
