package com.asiainfo.p5.javaCore.annotation;

import java.lang.annotation.Target;

@MyAnnotation	// @MyAnnotation注解到底能标在什么元素上，取决于注解类MyAnnotation在定义时标注的@Target的值是什么
public class MyClass {
	@MyAnnotation
	private int i;
	
	@MyAnnotation
	public void met1() {}
}
