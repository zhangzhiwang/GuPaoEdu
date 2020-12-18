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
//@Repository
//@Controller
//@Component
@Service("s1")
//@Primary// 当通过类型匹配找到多个bean是，被标注@Primary的bean优先注入
public class UserServiceImpl implements IUserService {
	private int id = 1;
	
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
	
//	public UserServiceImpl() {
//		System.out.println("s1无參构造方法被调用");
//	}
}
