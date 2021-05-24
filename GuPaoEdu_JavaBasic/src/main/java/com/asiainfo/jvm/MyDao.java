package com.asiainfo.jvm;

import java.util.ArrayList;
import java.util.List;


public class MyDao {
	public void query() {
		List<User> list = new ArrayList<>();
		int i = 10;
		while(i%10 == 0) {// 永远为true，测试OOM
			list.add(new User());
		}
//		return list;
	}
}
