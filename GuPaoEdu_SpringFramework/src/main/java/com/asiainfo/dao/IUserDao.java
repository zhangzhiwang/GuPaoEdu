package com.asiainfo.dao;

import java.util.List;

import com.asiainfo.entity.Cat;
import com.asiainfo.entity.Cat2;
import com.asiainfo.entity.Cat3;
import com.asiainfo.entity.User;
import com.asiainfo.entity.User3;

public interface IUserDao {
	User3 queryUser();
	void test1(String s);
	void m5(Cat cat, Cat2 cat2, Cat3 cat3);
	void m4();
	void m6();
	
	void insertUser(User user);
	List<User> queryAllUsers();
}
