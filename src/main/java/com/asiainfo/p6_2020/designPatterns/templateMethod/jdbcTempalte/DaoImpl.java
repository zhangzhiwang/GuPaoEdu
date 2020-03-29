package com.asiainfo.p6_2020.designPatterns.templateMethod.jdbcTempalte;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public class DaoImpl extends MyJdbcTempalte {

	public DaoImpl(DataSource dataSource) {
		super(dataSource);
	}

	public List<Student> getAllStudent() {
		String sql = "select * from t_student";
		List<Student> list = super.executeQuery(sql, new MyRowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int index) {
				Student student = new Student();
				try {
					student.setId(rs.getInt(0));
					student.setName(rs.getString(1));
					student.setGender(rs.getInt(2));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return student;
			}
		});

		return list;
	}

}
