package com.asiainfo.p6.softwareFrameworkDesignPrinciple.dip;

/**
 * 依赖倒置原则（Dependence Inversion Principle）：高层模块不要依赖底层模块，二者要依赖底层模块的抽象；抽象不依赖于细节，细节要依赖于抽象。这样就降低了高层模块和底层模块的耦合。</p>
 * 如果依赖不倒置，那么底层模块的变化会直接影响到高层模块，即高层模块会因底层模块的不断变化而作出修改
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 1:08:50 PM
 */
public class TestDIP {
	private static IPerson iPerson;
	
	static {// 模拟注入不同的实现
		iPerson = new Tom(new JavaCourse());
	}
	
	public static void main(String[] args) {
		iPerson.study();// 调用方是高层模块，Tom是底层模块，调用方不依赖具体的实现。当Tom换成Tim时，调用方不需要换代码，将Tim的实现注入给iPerson即可，而且如果Tom不学习Java课程了，学习别的了，那么给Tom注入其他课程即可。
	}
}
