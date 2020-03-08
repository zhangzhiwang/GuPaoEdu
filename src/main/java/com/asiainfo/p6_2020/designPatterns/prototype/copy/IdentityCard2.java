package com.asiainfo.p6_2020.designPatterns.prototype.copy;

import java.io.Serializable;

/**
 * 身份证
 *
 * @author zhangzhiwang
 * @date Mar 8, 2020 9:11:19 PM
 */
public class IdentityCard2 implements Serializable {
	private String idNum;

	public IdentityCard2() {
		super();
	}

	public IdentityCard2(String idNum) {
		super();
		this.idNum = idNum;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	@Override
	public String toString() {
		return "IdentityCard [idNum=" + idNum + "]";
	}
	
}
