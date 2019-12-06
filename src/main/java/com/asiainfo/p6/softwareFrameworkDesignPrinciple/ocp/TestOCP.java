package com.asiainfo.p6.softwareFrameworkDesignPrinciple.ocp;

/**
 * OCP测试</p>
 * 开闭原则(Open Close Principle)：用扩展来适应需求的变化而不是用修改来适应需求的变化，OCP是所有原则的核心。
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 12:51:15 PM
 */
public class TestOCP {
	private static ICourse iCourse;// 面向接口编程实际上也是体现了OCP原则：面向抽象而不是具体的实现，当具体的实现被换掉时，调用方不需要改动代码，只要替换的实现符合抽象的标准
	
	static {// 模拟注入不同的课程
		iCourse = new JavaDiscountCourse(1, "Java", 100);
	}
	
	public static void main(String[] args) {
		System.out.println(iCourse.getCoursePrice());
		
		// 根据不同的需求注入不同的实现即可
		iCourse = new BigDataCourse(2, "BigData", 200);
		System.out.println(iCourse.getCoursePrice());
		
		System.out.println("------------");
		JavaDiscountCourse javaDiscountCourse = new JavaDiscountCourse(1, "Java", 100);// 加入了JavaDiscountCourse类，既实现了需求的变化又没有修改原有逻辑
		System.out.println(javaDiscountCourse.getOriginPrice());
		System.out.println(javaDiscountCourse.getDiscountPrice(0.5));
	}
}
