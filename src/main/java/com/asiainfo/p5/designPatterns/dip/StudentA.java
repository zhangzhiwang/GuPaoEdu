package com.asiainfo.p5.designPatterns.dip;

public class StudentA {
	private ICourse course;

	public StudentA() {
		super();
	}

	public StudentA(ICourse course) {
		super();
		this.course = course;
	}

	public void study() {
		System.out.println("StudentA学" + course.getName());
	}
}
