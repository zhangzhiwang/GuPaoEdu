package com.asiainfo.p6.designPatterns.factory.simpleFactory;

import com.asiainfo.p6.designPatterns.factory.AICourse;
import com.asiainfo.p6.designPatterns.factory.ICourse;
import com.asiainfo.p6.designPatterns.factory.JavaCourse;

/**
 * 简单工厂
 *
 * @author zhangzhiwang
 * @date Oct 22, 2019 8:44:47 PM
 */
public class SimpleFactory {
	
	/**
	 * 创建课程
	 * 
	 * @param name
	 * @return
	 * @author zhangzhiwang
	 * @date Oct 22, 2019 8:50:59 PM
	 */
	public static ICourse create(String name) {
		if("java".equals(name)) {
			return new JavaCourse();
		} else if("ai".equals(name)) {
			return new AICourse();
		}
		
		return null;
	}
	
	public static ICourse create(Class clazz) {
		try {
			return (ICourse) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
