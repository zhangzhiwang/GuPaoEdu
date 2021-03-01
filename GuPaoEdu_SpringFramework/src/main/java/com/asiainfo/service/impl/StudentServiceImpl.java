package com.asiainfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.dao.IStudentDao;
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

}
