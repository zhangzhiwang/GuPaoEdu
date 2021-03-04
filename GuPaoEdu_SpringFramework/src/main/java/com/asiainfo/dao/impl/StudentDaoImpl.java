package com.asiainfo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asiainfo.dao.IStudentDao;
import com.asiainfo.entity.Student;
import com.asiainfo.mapper.StudentMapper;

@Repository
public class StudentDaoImpl implements IStudentDao {
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public void met1() {
		System.out.println("StudentDaoImpl.met1 ...");
	}

	@Override
	public void insert(Student student) {
		studentMapper.insert(student);
	}
	
	@Override
	public void delete(long id) {
		studentMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void update(Student student) {
		studentMapper.updateByPrimaryKey(student);
	}
	
	@Override
	public Student query(long id) {
		return studentMapper.selectByPrimaryKey(id);
	}
}
