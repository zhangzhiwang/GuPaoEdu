package com.asiainfo.service;

import com.asiainfo.entity.Cat;
import com.asiainfo.entity.Cat2;
import com.asiainfo.entity.Cat3;
import com.asiainfo.entity.User3;

public interface IUserService {
	User3 queryUser();
	
	void m1();
	
	String m2();
	
	String m3(int i);
	
	String m3(String i);

	String m3(String i, byte b);
	
	void m3(byte i);
	
	void m3(short s) throws ArrayIndexOutOfBoundsException;
	
	void m3(short s1, short s2) throws NumberFormatException;
	
	void m4();
	
	void m5(Cat cat);
	
	void m5(Cat cat, Cat2 cat2, Cat3 cat3);
	
	void m6();
}
