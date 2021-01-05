package com.asiainfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.asiainfo.dao.IUserDao;
import com.asiainfo.entity.Cat;
import com.asiainfo.entity.Cat2;
import com.asiainfo.entity.Cat3;
import com.asiainfo.entity.User3;
import com.asiainfo.service.IUserService;

import lombok.Data;

@Data
@Service("s2")
//@Primary
public class UserServiceImpl2 implements IUserService {
	private int id = 2;
	
	@Autowired
	private IUserDao userDao;

	@Override
	public User3 queryUser() {
		return userDao.queryUser();
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String m2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String m3(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String m3(String i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String m3(String i, byte b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void m3(byte i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m3(short s) throws ArrayIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m3(short s1, short s2) throws NumberFormatException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m5(Cat cat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m5(Cat cat, Cat2 cat2, Cat3 cat3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m6() {
		// TODO Auto-generated method stub
		
	}
	
//	public UserServiceImpl2() {
//		System.out.println("s2无參构造方法被调用");
//	}
}
