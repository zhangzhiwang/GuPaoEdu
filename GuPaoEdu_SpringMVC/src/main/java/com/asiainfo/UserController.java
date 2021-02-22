package com.asiainfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserController implements Controller{// 如果不使用注解那么控制器必须实现org.springframework.web.servlet.mvc.Controller接口并重写handleRequest方法

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("进入UserController.handleRequest");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/index.jsp");
		return mav;
	}
}
