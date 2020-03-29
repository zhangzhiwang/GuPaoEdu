package com.asiainfo.p6_2020.designPatterns.templateMethod.jdbcTempalte;

import java.sql.ResultSet;

public interface MyRowMapper<T> {
	T mapRow(ResultSet rs, int index);
}
