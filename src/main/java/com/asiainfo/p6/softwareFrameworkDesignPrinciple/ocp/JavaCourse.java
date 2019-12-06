package com.asiainfo.p6.softwareFrameworkDesignPrinciple.ocp;

/**
 * Java课程
 *
 * @author zhangzhiwang
 * @date Oct 14, 2019 2:05:08 PM
 */
public class JavaCourse implements ICourse {
	private int courseId;
	private String courseName;
	private double coursePrice;

	public JavaCourse(int courseId, String courseName, double coursePrice) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
	}

	public JavaCourse() {
		super();
	}

	@Override
	public int getCourseId() {
		return courseId;
	}

	@Override
	public String getCourseName() {
		return courseName;
	}

	@Override
	public double getCoursePrice() {
		return coursePrice;
	}
}
