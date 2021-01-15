package com.asiainfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.ITestSon1;
import com.asiainfo.dao.IStudentDao;
import com.asiainfo.entity.Student;
import com.asiainfo.entity.Student2;
import com.asiainfo.entity.Student3;
import com.asiainfo.mapper.StudentMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentService {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private IStudentDao studentDao;
	
	public Student2 queryByIdWithJpa(int id) {
		System.out.println("studentDao = " + studentDao.toString());
		System.out.println(studentDao instanceof org.springframework.data.jpa.repository.support.SimpleJpaRepository);
		return studentDao.getOne(1);
	}
	
	@Cacheable(value = "aaa", key = "#id")
	public Student queryById(int id) {
		System.out.println("queryById...");
		return studentMapper.queryById(id);
	}
	
	public List<Student3> getAll() {
		return studentMapper.queryAll();
	}
}
