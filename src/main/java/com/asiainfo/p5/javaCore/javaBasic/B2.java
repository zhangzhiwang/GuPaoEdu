/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic;

import java.io.Serializable;

/**
 * 
 *
 * @author Administrator
 * @date 2020年2月2日 上午11:17:10
 */
public class B2 implements Serializable {
	private int b;
	private C2 c;

	/**
	 * @param b
	 * @param c
	 */
	public B2(int b, C2 c) {
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
	public C2 getC2() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC2(C2 c) {
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
}
