package com.asiainfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.dao.IStudentDao;
import com.asiainfo.entity.Student;
import com.asiainfo.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentDao studentDao;
	
	@Override
	public void met1() {
		System.out.println("StudentServiceImpl.met1 ...");
		studentDao.met1();
	}
	
	@Override
	public void insert(Student student) {
		studentDao.insert(student);
	}

	@Override
	public void delete(long id) {
		studentDao.delete(id);
		
	}

	@Override
	public void update(Student student) {
		studentDao.update(student);
		
	}

	@Override
	public Student query(long id) {
		return studentDao.query(id);
	}

}
