package com.asiainfo.service;

import com.asiainfo.entity.Student;

public interface IStudentService {
	void met1();
	void insert(Student student);
	void delete(long id);
	void update(Student student);
	Student query(long id);
}
