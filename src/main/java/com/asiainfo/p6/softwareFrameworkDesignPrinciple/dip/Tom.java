package com.asiainfo.p6.softwareFrameworkDesignPrinciple.dip;

/**
 * Tom
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 1:12:59 PM
 */
public class Tom implements IPerson {
	private ICourse iCourse;
	
	public Tom(ICourse iCourse) {
		this.iCourse = iCourse;
	}
	
	@Override
	public void study() {
		System.out.println("Tom在学习" + iCourse.getCourseName());
	}

}
