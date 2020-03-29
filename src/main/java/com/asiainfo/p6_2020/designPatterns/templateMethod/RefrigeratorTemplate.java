package com.asiainfo.p6_2020.designPatterns.templateMethod;

/**
 * 冰箱模板：把大象关进冰箱以供分为几步？
 *
 * @author zhangzhiwang
 * @date Mar 27, 2020 2:09:18 PM
 */
public abstract class RefrigeratorTemplate {
	/**
	 * 把大象放冰箱以供分三步
	 * 
	 * @author zhangzhiwang
	 * @date Mar 27, 2020 2:11:53 PM
	 */
	public final void putEleIntoFridge() {// 一定是final的，这样子类不能复写该方法也就不能破坏做事的顺序
		// 做一件事情的顺序是定死的，但是具体每一步该怎么做由子类说的算
		// 第一步：打开冰箱门
		openFridge();

		// 第二步：把大象放进去
		putElephant();

		// 第三步：把冰箱门关上
		closeFridge();
		
		// 第四步：清理冰箱（可选）
		if(needClean()) {
			cleanFridge();
		}
	}

	protected void cleanFridge() {
		System.out.println("清理冰箱默认实现");
	}

	/**
	 * 钩子方法——做一件事情的步骤在父类中已经给定义好了，子类不允许改变这些步骤，只能改变做某些步骤的方式。但是在父类中，有的步骤是必须的，有的步骤是可选的，那这些可选的步骤做不做是有子类说的算，那么这些步骤得有个判断条件，条件满足时才执行该步骤。钩子方法就是这个判断条件，如本例中的needClean()方法</p>
	 * 如果子类想清理冰箱就复写needClean()方法并返回true，如果不想清理就返回false。在父类中钩子方法可以是抽象方法也可以是提供默认实现的方法，比如父类中needClean()方法默认返回false，意味着默认是不清理冰箱的，如果子类想清理就要复写该方法并返回true，不复写就默认不清理。</p>
	 * 为什么叫“钩子方法”呢？是因为在整个算法的骨架中可能会有一些“挂在点”被用来接受外界的干预，钩子方法是“钩”在那些挂载点上的，子类通过选择性地重写钩子方法来对那些具有“挂载点”的步骤进行干预。
	 * 
	 * @return
	 * @author zhangzhiwang
	 * @date Mar 29, 2020 11:08:26 AM
	 */
	protected  boolean needClean() {
		return false;
	}

	protected void closeFridge() {
		System.out.println("关闭冰箱门默认实现");
	}

	protected void putElephant() {
		System.out.println("放大象默认实现");
	}

	protected void openFridge() {
		System.out.println("打开冰箱门默认实现");
	}
}
