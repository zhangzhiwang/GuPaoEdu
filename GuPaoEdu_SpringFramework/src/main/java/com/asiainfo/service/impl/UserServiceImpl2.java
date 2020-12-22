package com.asiainfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.asiainfo.dao.IUserDao;
import com.asiainfo.entity.User;
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
	public User queryUser() {
		return userDao.queryUser();
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
//	public UserServiceImpl2() {
//		System.out.println("s2无參构造方法被调用");
//	}
}