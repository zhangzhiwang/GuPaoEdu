/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic;

import java.io.Serializable;

/**
 * 抽象类测试
 *
 * @author Administrator
 * @date 2020年1月31日 下午1:37:43
 */
public abstract class AbstractClass implements Serializable {
	// 在抽象类里面除了抽象方法不能是private的之外，其他任何方法（包括普通方法、抽象方法和构造方法）和成员属性可以是任何访问控制权限的
	private int i;
	long l;
	protected String s;
	public char c;
	
	static {}
	
	void met1() {}
	abstract void met1_1();
	
	protected void met2() {}
	protected abstract void met2_1();
	
	public void met3() {}
	public abstract void met3_1();
	
	private void met4() {}// 抽象类的普通方法（非抽象方法）可以是私有的
//	private abstract void met4_1();// 抽象方法不能是私有的：The abstract method met4_1 in type AbstractClass can only set a visibility modifier, one of public or protected
	
	public static void met5() {}
	private static void met6() {}
	protected static void met7() {}
	static void met8() {}
//	public abstract static void met6();// 由于抽象方法的存在是为了被复写，而子类是不能复写父类的静态方法的，所以抽象方法不能是静态的。
	
	public AbstractClass() {}
	
	public AbstractClass(int i) {}
	
	protected AbstractClass(int i, String s) {}
	
	AbstractClass(String s) {}
	
	public static void main(String[] args) {
//		AbstractClass a = new AbstractClass();// 抽象类不能实例化
	}
	
}
