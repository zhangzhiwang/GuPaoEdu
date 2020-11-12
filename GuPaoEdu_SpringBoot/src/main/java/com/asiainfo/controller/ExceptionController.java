package com.asiainfo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = {NullPointerException.class})
	public ModelAndView handleNullPointer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("nullPointer");// 在/resources/templates下面创建相应的页面
		return modelAndView;
	}
	
	@ExceptionHandler(value = {ArrayIndexOutOfBoundsException.class})
	public ModelAndView handleArrayIndexOutOfBoundsException() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("arrayIndexOutOfBounds");
		return modelAndView;
	}
}
