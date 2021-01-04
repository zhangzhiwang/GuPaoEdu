package com.asiainfo.dao;

import com.asiainfo.entity.Cat;
import com.asiainfo.entity.Cat2;
import com.asiainfo.entity.Cat3;
import com.asiainfo.entity.User;

public interface IUserDao {
	User queryUser();
	void test1(String s);
	void m5(Cat cat, Cat2 cat2, Cat3 cat3);
	void m4();
	void m6();
}
