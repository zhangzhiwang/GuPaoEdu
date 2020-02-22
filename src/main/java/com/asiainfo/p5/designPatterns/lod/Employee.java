package com.asiainfo.p5.designPatterns.lod;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	public void count(List<Order> list) {
		System.out.println(list.size());
	}
	
	public void count() {// 让Employee和Order打交道
		List<Order> list = new ArrayList<Order>();
		list.add(new Order());
		System.out.println(list.size());
	}
}
