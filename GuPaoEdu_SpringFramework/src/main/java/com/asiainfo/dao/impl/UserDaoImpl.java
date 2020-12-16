package com.asiainfo.dao.impl;

import org.springframework.stereotype.Repository;

import com.asiainfo.dao.IUserDao;
import com.asiainfo.entity.User;

@Repository
public class UserDaoImpl implements IUserDao {
	@Override
	public User queryUser() {
		return new User("查询结果", -1);
	}
}
