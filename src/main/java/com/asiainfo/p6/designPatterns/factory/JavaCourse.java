package com.asiainfo.p6.designPatterns.factory;

/**
 * java课程
 *
 * @author zhangzhiwang
 * @date Oct 22, 2019 8:50:27 PM
 */
public class JavaCourse implements ICourse{

	@Override
	public void record() {
		System.out.println("上java课程");
	}

}
