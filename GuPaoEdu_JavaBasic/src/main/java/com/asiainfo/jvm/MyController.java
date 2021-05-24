package com.asiainfo.jvm;

import java.util.List;


public class MyController {
	private MyService myService = new MyService();
	
	public void query() {
		 myService.query();
	}
}
