package com.asiainfo.p6_2020.designPatterns.prototype.homework;

import com.alibaba.fastjson.JSON;

/**
 * 用JSON方式实现一个原型模式的深克隆
 *
 * @author zhangzhiwang
 * @date Mar 12, 2020 9:17:02 PM
 */
public class PrototypeJson {
	private int num;

	public PrototypeJson() {
		super();
	}

	public PrototypeJson(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "PrototypeJson [num=" + num + "]";
	}

	public static void main(String[] args) {
		PrototypeJson p1 = new PrototypeJson(100);
		System.out.println("p1 = " + p1);
		String jsonString = JSON.toJSONString(p1);
		PrototypeJson p2 = JSON.parseObject(jsonString, PrototypeJson.class);
		System.out.println("p2 = " + p2);
		System.out.println(p1 == p2);
		p1.setNum(200);
		System.out.println("p1 = " + p1);
		System.out.println("p2 = " + p2);
	}
}