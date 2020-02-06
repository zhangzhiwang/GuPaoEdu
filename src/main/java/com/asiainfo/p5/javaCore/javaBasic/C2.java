/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic;

import java.io.Serializable;

/**
 * 
 *
 * @author Administrator
 * @date 2020年2月2日 上午11:17:16
 */
public class C2 {
	private int c;
	private String name;

	/**
	 * @param c
	 * @param name
	 */
	public C2(int c, String name) {
		super();
		this.c = c;
		this.name = name;
	}

	/**
	 * @return the c
	 */
	public int getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(int c) {
		this.c = c;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "C [c=" + c + ", name=" + name + "]";
	}
}
