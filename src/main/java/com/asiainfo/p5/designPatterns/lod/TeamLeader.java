package com.asiainfo.p5.designPatterns.lod;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader {
	public void command(Employee employee) {// TeamLeader让Employee去统计订单数量，那么Employee和订单Order打交道就可以了，TeamLeader不需要和Order打交道
//		List<Order> list = new ArrayList<Order>();
//		list.add(new Order());// 将此部分逻辑放到Employee里面去
		
//		employee.count(list);
		employee.count();
	}
}
