/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic;

import java.io.Serializable;

/**
 * 
 *
 * @author Administrator
 * @date 2020年2月2日 上午11:16:38
 */
public class A2 implements Serializable {
	private int a;
	private B2 b;

	/**
	 * @param a
	 * @param b
	 */
	public A2(int a, B2 b) {
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
	public B2 getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(B2 b) {
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
}
