package com.asiainfo.dao.impl;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.asiainfo.aop.MyAnnotation1;
import com.asiainfo.aop.MyAnnotation2;
import com.asiainfo.dao.IUserDao;
import com.asiainfo.entity.Cat;
import com.asiainfo.entity.Cat2;
import com.asiainfo.entity.Cat3;
import com.asiainfo.entity.User;

@Repository
//@Controller
@MyAnnotation1
public class UserDaoImpl implements IUserDao {
	@Override
	public User queryUser() {
		return new User("查询结果", -1);
	}
	
	public void test1(String s) {
		System.out.println("UserDaoImpl.test1");
	}
	
	public void m5(Cat cat, Cat2 cat2, Cat3 cat3) {
		System.out.println("UserDaoImpl.m5");
	}
	
	public void m4() {
		System.out.println("UserDaoImpl.m4");
	}
	
	@MyAnnotation2
	public void m6() {
		System.out.println("UserDaoImpl.m6");
	}
}
