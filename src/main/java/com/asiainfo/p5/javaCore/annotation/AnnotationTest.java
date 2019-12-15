package com.asiainfo.p5.javaCore.annotation;

import java.util.Date;

/**
 * 注解</p>
 * 1、注解是一个继承了Annotation接口的接口，即一个注解类是Annotation接口的子接口</p>
 * 2、注解类的声明使用@interface
 *
 * @author zhangzhiwang
 * @date 2019年12月14日 下午9:30:59
 */
public class AnnotationTest {
	public static void main(String[] args) {
		Thread t = new Thread();
		t.stop();// 该方法被划了横线，说明该方法已标注为过期，点进去看源码发现该方法标注了@Deprecated注解
		
		Date date = new Date(2019, 12, 15);
	}
}
