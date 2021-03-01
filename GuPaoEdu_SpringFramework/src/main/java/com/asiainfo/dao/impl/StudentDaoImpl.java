package com.asiainfo.dao.impl;

import org.springframework.stereotype.Repository;

import com.asiainfo.dao.IStudentDao;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Override
	public void met1() {
		System.out.println("StudentDaoImpl.met1 ...");
	}

}
