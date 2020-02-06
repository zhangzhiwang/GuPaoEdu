/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 子类
 *
 * @author Administrator
 * @date 2020年1月31日 上午10:53:12
 */
public class Son extends Father implements Cloneable {
	int num = 20;
	String name ="zzw";
	
	public String met1(int i, String s) {// 重载父类的方法，重载也可以发生在父子类当中
		System.out.println("com.asiainfo.p5.javaCore.javaBasic.Son.met1(int, String)");
		return "";
	}
	
	@Override
	public int met1(int i) {
		System.out.println("com.asiainfo.p5.javaCore.javaBasic.Son.met1(int)");
		return 0;
	}
	
	public int met2(int i) {
		return 0;
	}
	
//	public double met2(int i) {// 方法名称和参数列表相同，但方法的访问控制符、返回值类型和抛出异常列表不同不能作为方法的重载
//		return 0;
//	}
	
//	protected double met2(int i) {// 方法名称和参数列表相同，但方法的访问控制符、返回值类型和抛出异常列表不同不能作为方法的重载
//		return 0;
//	}
	
//	public int met2(int i) throws IOException {// 方法名称和参数列表相同，但方法的访问控制符、返回值类型和抛出异常列表不同不能作为方法的重载
//		return 0;
//	}
	
	public int met2(int i, String s) throws IOException {// 方法名称和参数列表相同，但方法的访问控制符、返回值类型和抛出异常列表不同不能作为方法的重载
		return 0;
	}
	
	//-----------以上是测试方法重载，下面测试方法重写---------------------
	
//	@Override
//	// 访问控制符不能小于父类的
//	private Father met3(int i) throws IOException {// 编译不通过：Cannot reduce the visibility of the inherited method from Father
//		return null;
//	}
	
//	@Override
//	// protected > default权限
//	// 返回值类型的范围不能大于父类
//	protected Object met3(int i) throws IOException {// 编译不通过
//		return null;
//	}
	
//	@Override
//	// protected > default权限
//	// 返回值类型的范围可以小于父类
//	// 名称和参数列表必须相同，这个不测试了
//	// 子类抛出的异常的范围不能大于父类的
//	protected Son met3(int i) throws Exception {// 编译不通过
//		return null;
//	}
	
	@Override
	// protected > default权限
	// 返回值类型的范围可以小于父类
	// 名称和参数列表必须相同，这个不测试了
	// 子类抛出的异常的范围不能大于父类的
	protected Son met3(int i) throws FileNotFoundException {// FileNotFoundException是IOException的子类
		return null;
	}

	@Override
	public int met4() {// 如果父类的返回值类型是void或者是基本数据类型，子类必须与父类保持一致
		return 0;
	}
	
	@Override
	public void met5(Father f) {// 子类的入参必须和父类的完全一致，入参不能是父类入参的子类型
		
	}
	
	public void met7() {
		System.out.println("com.asiainfo.p5.javaCore.javaBasic.Son.met7()");
	}
	
	public static void main(String[] args) {
//		Son son = new Son();
////		son.met1(1);
//		son.met1(1, "");
		
//		Father f = new Son();
//		System.out.println(f.num);
//		System.out.println(f.name);// 多态访问不到子类的特有的方法和任何属性（包括和父类的同名属性和特有属性）
		
		// 向下转型
		Father father = new Son();
		Son son = (Son) father;// 向下转型和直接new一个子类对象并赋值给子类引用是一样的，即本行代码等同于Son son = new Son();
//		System.out.println(son.num);
//		son.met1(1);
		son.met6(null);
		son.met7();
	}
	
	@Override
	public Son clone() throws CloneNotSupportedException {
		return (Son) super.clone();
	}
}
