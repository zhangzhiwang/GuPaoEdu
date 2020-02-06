/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic;

/**
 * 
 *
 * @author Administrator
 * @date 2020年2月2日 上午11:17:10
 */
public class B implements Cloneable {
	private int b;
	private C c;

	/**
	 * @param b
	 * @param c
	 */
	public B(int b, C c) {
		super();
		this.b = b;
		this.c = c;
	}

	/**
	 * @return the b
	 */
	public int getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(int b) {
		this.b = b;
	}

	/**
	 * @return the c
	 */
	public C getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(C c) {
		this.c = c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "B [b=" + b + ", c=" + c + "]";
	}

	@Override
	public B clone() throws CloneNotSupportedException {
		B b = (B) super.clone();
//		C newC = b.getC().clone();// 测试A、B是深拷贝，C是浅拷贝
//		b.setC(newC);
		return b;
	}
}
