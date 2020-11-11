package com.asiainfo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		System.out.println("进入MyHandlerExceptionResolver...");
		
		ModelAndView modelAndView = new ModelAndView();
		if(ex instanceof NullPointerException) {
			modelAndView.setViewName("nullPointer");
		} else if(ex instanceof ArrayIndexOutOfBoundsException) {
			modelAndView.setViewName("arrayIndexOutOfBounds");
		}
		return modelAndView;
	}
}
