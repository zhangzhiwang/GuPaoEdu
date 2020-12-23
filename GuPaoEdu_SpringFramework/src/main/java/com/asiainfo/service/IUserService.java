package com.asiainfo.service;

import com.asiainfo.entity.User;

public interface IUserService {
	User queryUser();
	
	void m1();
	
	String m2();
	
	String m3(int i);
	
	String m3(String i);

	String m3(String i, byte b);
	
	void m3(byte i);
	
	void m3(short s) throws ArrayIndexOutOfBoundsException;
	
	void m3(short s1, short s2) throws NumberFormatException;
	
	void m4();
}
