package com.asiainfo.mapper;

import java.util.List;

import com.asiainfo.entity.Student;
import com.asiainfo.entity.Student3;

public interface StudentMapper {
	Student queryById(int id);
	
	List<Student3> queryAll();
}
