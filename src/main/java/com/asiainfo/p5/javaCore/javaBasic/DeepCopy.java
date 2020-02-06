/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic;

/**
 * 深拷贝
 * </P>
 * 深拷贝的实现方式一——每一层的每个对象都进行浅拷贝=深拷贝</p>
 * 通过复写Object类的clone方法实现深拷贝的步骤：</p>
 * 1、对每一层需要深拷贝的对象都进行浅拷贝</p>
 * 2、然后在该对象浅拷贝完之后，再上一层将拷贝出新生成的对象设置到属性里面即可</p>
 * 通过这种方法可以实现某些字段浅拷贝某些字段深拷贝
 *
 * @author Administrator
 * @date 2020年2月2日 上午11:13:00
 */
public class DeepCopy implements Cloneable {
	private int num;
	private A a;

	/**
	 * @param num
	 * @param a
	 */
	public DeepCopy(int num, A a) {
		super();
		this.num = num;
		this.a = a;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the a
	 */
	public A getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(A a) {
		this.a = a;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeepCopy [num=" + num + ", a=" + a + "]";
	}

	@Override
	public DeepCopy clone() throws CloneNotSupportedException {
		DeepCopy deepCopy = (DeepCopy) super.clone();
		A newA = deepCopy.getA().clone();
		deepCopy.setA(newA);
		return deepCopy;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		C c = new C(30, "CCC");
		B b = new B(20, c);
		A a = new A(10, b);
		DeepCopy deepCopy = new DeepCopy(100, a);
		System.out.println(deepCopy);
		
		//深拷贝
		DeepCopy deepCopy2 = deepCopy.clone();
		System.out.println(deepCopy2);
		
		// 测试深拷贝
		deepCopy.getA().getB().getC().setName("CCCsssCCC");
		System.out.println("-----------------");
		System.out.println(deepCopy);
		System.out.println(deepCopy2);
		
		deepCopy.getA().getB().setB(201);
		System.out.println("-----------------");
		System.out.println(deepCopy);
		System.out.println(deepCopy2);
		
		deepCopy.getA().setA(101);
		System.out.println("-----------------");
		System.out.println(deepCopy);
		System.out.println(deepCopy2);
		
		deepCopy.setNum(99);
		System.out.println("-----------------");
		System.out.println(deepCopy);
		System.out.println(deepCopy2);// 可以发现改变deepCopy的任何字段deepCopy2都不会受影响
	}
}
