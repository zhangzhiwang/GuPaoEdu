package com.asiainfo.jvm;

import java.util.List;


public class MyService {
	private MyDao myDao = new MyDao();
	
	public void query() {
		 myDao.query();
	}
}
