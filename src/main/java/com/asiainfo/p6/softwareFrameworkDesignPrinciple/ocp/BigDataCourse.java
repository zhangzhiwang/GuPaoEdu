package com.asiainfo.p6.softwareFrameworkDesignPrinciple.ocp;

/**
 * 大数据课程
 *
 * @author zhangzhiwang
 * @date Oct 14, 2019 2:05:08 PM
 */
public class BigDataCourse implements ICourse {
	private int courseId;
	private String courseName;
	private double coursePrice;

	public BigDataCourse(int courseId, String courseName, double coursePrice) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
	}

	public BigDataCourse() {
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
