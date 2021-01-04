package com.asiainfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.asiainfo.aop.MyAnnotation1;
import com.asiainfo.aop.MyAnnotation2;
import com.asiainfo.dao.IUserDao;
import com.asiainfo.entity.Cat;
import com.asiainfo.entity.Cat2;
import com.asiainfo.entity.Cat3;
import com.asiainfo.entity.User;
import com.asiainfo.service.IUserService;

import lombok.Data;

@Data
//@Repository
//@Controller
//@Component
@Service("s1")
//@Primary// 当通过类型匹配找到多个bean是，被标注@Primary的bean优先注入
@MyAnnotation1
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
	
	/** 以下是aop的测试 */
	
	public void m1() {
		System.out.println("m1");
	}
	
	public String m2() {
		System.out.println("m2");
		return "m2";
	}
	
	public String m3(int i) {
		System.out.println("m3");
		return "m3 : " + i;
	}
	
	public String m3(String i) {
		System.out.println("m3");
		return "m3 : " + i;
	}
	
	public String m3(String i, byte b) {
		System.out.println("m3");
		return "m3 : " + i;
	}
	
	public void m3(byte i) {
		System.out.println("m3_byte");
	}
	
	public void m3(short s) throws ArrayIndexOutOfBoundsException {
		System.out.println("m3_ArrayIndexOutOfBoundsException");
	}
	
	public void m3(short s1, short s2) throws NumberFormatException {
		System.out.println("m3_NumberFormatException");
	}
	
	@Override
	public void m4() {
		System.out.println("m4");
	}
	
	public void m5(Cat cat) {
		System.out.println("m5");
	}
	
	public void m5(Cat cat, Cat2 cat2, Cat3 cat3) {
		System.out.println("m5");
	}
	
	@MyAnnotation2
	public void m6() {
		System.out.println("m6");
	}
}
