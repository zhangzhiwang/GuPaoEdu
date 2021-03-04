package com.asiainfo.dao;

import com.asiainfo.entity.Student;

public interface IStudentDao {
	void met1();
	void insert(Student student);
	void delete(long id);
	void update(Student student);
	Student query(long id);
}
