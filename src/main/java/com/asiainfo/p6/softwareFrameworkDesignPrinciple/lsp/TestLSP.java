package com.asiainfo.p6.softwareFrameworkDesignPrinciple.lsp;

/**
 * 里氏替换原则（Liskov Substitution Principle）：就一句话——子类可以完全替换他的父类而不会产生任何错误或异常，调用方可以完全不需要知道是父类还是子类在工作
 * 参考资料：https://blog.csdn.net/fangxinde/article/details/83653958
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 8:57:48 PM
 */
public class TestLSP {
	/**
	 * 1、Java的继承体系允许子类复写父类的方法，但是违背了里氏替换原则。LSP的核心就是子类完全替换父类之后调用方不会出现任何问题。假如调用方想骑着一只鸟去天上飞，“鸟”是父类，“企鹅”是子类，“鸟”类有一个飞翔的方法，企鹅继承了鸟类也获得了飞翔的方法，但是企鹅不会飞会游泳，于是企鹅就复写了父类飞翔的方法，
	 * 	  调用企鹅的飞翔方法后会钻到水里面去游泳。OK，现在有一个人（调用方）想骑一只鸟到天上飞翔，之前调用的是父类——“鸟”类，调用鸟类的飞翔方法后就腾空而起。现在用子类企鹅去替换父类，换完之后调用企鹅的飞翔方法，然后嗖地一下钻进了水里，把人给淹死了（调用方因替换子类而出现了和之前不一样的行为）。
	 * 	  所以，为了保证替换子类后行为方法不变的最佳做法就是不让子类复写父类的方法，这样即使替换成子类后调用的还是父类的方法。
	 * 2、LSP适用的场景是：在替换子类之后，调用方由于不知道父类已经被替换成子类还是按照原来调用父类的方式去调用，调用方不能出现任何问题。
	 * 	  子类可以扩展父类没有的方法，如果调用方还是按照之前调用父类的方式去调用，只不过替换子类后那些特有的方法用不到而已，但不会对现有的功能产生影响
	 * 3、大口子：口子要比父类的大，既然子类能够完全替换父类，那么子类在实现父类的抽象方法时，入口的要求要更宽松，这样按照父类的要求去调用子类的方法一定不会有问题
	 * 4、小屁股：子类在实现父类的抽象方法时，返回值的范围要比父类的小，这样保证了子类的返回值一定在父类返回值的范围内
	 */
}
