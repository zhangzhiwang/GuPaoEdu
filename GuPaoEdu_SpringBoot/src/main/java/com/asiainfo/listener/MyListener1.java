package com.asiainfo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener1 implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyListener_1 init");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyListener_1 destroy");
	}
}
