package com.asiainfo.p6_2020.designPatterns.prototype.copy;

/**
 * 身份证
 *
 * @author zhangzhiwang
 * @date Mar 8, 2020 9:11:19 PM
 */
public class IdentityCard implements Cloneable {
	private String idNum;

	public IdentityCard() {
		super();
	}

	public IdentityCard(String idNum) {
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
	
	@Override
	public IdentityCard clone() {
		try {
			return (IdentityCard) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
