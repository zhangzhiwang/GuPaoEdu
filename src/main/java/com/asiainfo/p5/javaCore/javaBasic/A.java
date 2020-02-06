/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic;

/**
 * 
 *
 * @author Administrator
 * @date 2020年2月2日 上午11:16:38
 */
public class A implements Cloneable {
	private int a;
	private B b;

	/**
	 * @param a
	 * @param b
	 */
	public A(int a, B b) {
		super();
		this.a = a;
		this.b = b;
	}

	/**
	 * @return the a
	 */
	public int getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(int a) {
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public B getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(B b) {
		this.b = b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "A [a=" + a + ", b=" + b + "]";
	}

	@Override
	public A clone() throws CloneNotSupportedException {
		A a = (A) super.clone();
		B newB = a.getB().clone();
		a.setB(newB);
		return a;
	}

}
