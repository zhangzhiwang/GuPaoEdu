package com.asiainfo.p5.javaCore.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 元注解测试
 *
 * @author zhangzhiwang
 * @date 2019年12月15日 下午9:04:35
 */
@SuppressWarnings("rawtypes")
public class MetaAnnotationTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// 测试@Target的值
		Class clazz = MyClass.class;
		Annotation[] annotations = clazz.getAnnotations();
		System.out.println(annotations.length);
//		System.out.println(annotations[0]);
		System.out.println(clazz.isAnnotationPresent(MyAnnotation.class));// 某个class是否标注了指定的注解，是通过反射来获取，所以相关的注解的作用范围必须是RUNTIME
		
		// 测试@Retention，改变RetentionPolicy的值，通过反编译工具查看class文件，可以看出SOURCE级别的在class里面注解已经被去掉了，而另两个级别在class文件里面都有
		
		// 测试@Inherited
		System.out.println("--------------");
		clazz = MyClassExt.class;
		Annotation[] annotations2 = clazz.getAnnotations();
		System.out.println(annotations2.length);
		
		System.out.println("--------------");
		clazz = MyInterface.class;
		Annotation[] annotations3 = clazz.getAnnotations();
		System.out.println(annotations3.length);
		System.out.println("--------------");
		clazz = MyInterfaceExt.class;
		Annotation[] annotations4 = clazz.getAnnotations();
		System.out.println(annotations4.length);
		System.out.println("--------------");
		clazz = MyInterfaceImpl.class;
		Annotation[] annotations5 = clazz.getAnnotations();
		System.out.println(annotations5.length);
	}
}
