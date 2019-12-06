package com.asiainfo.p6.softwareFrameworkDesignPrinciple.ocp;

/**
 * Java课程（打折）</p>
 * 需求发生变更：Java课程有打折优惠。如果修改JavaCourse类的getCoursePrice()方法，会有两个后果：一个是修改后原始价格就没有了，第二个getCoursePrice()方法会被其他好多地方调用，如果你改了这个方法，势必会影响到好多调用方。</p>
 * 解决方案：通过继承JavaCourse类来达到扩展来适应需求的变化，而不是修改原有JavaCourse类
 *
 * @author zhangzhiwang
 * @date Oct 14, 2019 2:05:08 PM
 */
public class JavaDiscountCourse extends JavaCourse {
	public JavaDiscountCourse(int courseId, String courseName, double coursePrice) {
		super(courseId, courseName, coursePrice);
	}
	
	/**
	 * 获取原始价格
	 * 
	 * @return
	 * @author zhangzhiwang
	 * @date Oct 21, 2019 12:46:36 PM
	 */
	public double getOriginPrice() {
		return super.getCoursePrice();
	}
	
	/**
	 * 获取打折后的价格
	 * 
	 * @param rate 折扣率
	 * @return
	 * @author zhangzhiwang
	 * @date Oct 21, 2019 12:46:23 PM
	 */
	public double getDiscountPrice(double rate) {
		return super.getCoursePrice() * rate;
	}
}
