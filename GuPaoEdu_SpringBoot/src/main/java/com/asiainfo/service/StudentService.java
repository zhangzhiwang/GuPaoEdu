package com.asiainfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.entity.Student;
import com.asiainfo.mapper.StudentMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentService {
	@Autowired
	private StudentMapper studentMapper;
	
	@Cacheable(value = "aaa", key = "#id")
	public Student queryById(int id) {
		System.out.println("queryById...");
		return studentMapper.queryById(id);
	}
}
