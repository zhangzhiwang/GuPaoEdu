package com.asiainfo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

public class MyListener2 implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyListener_2 init");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyListener_2 destroy");
	}
}
