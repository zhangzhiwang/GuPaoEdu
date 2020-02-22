package com.asiainfo.p5.designPatterns.lod;

/**
 * 迪米特法则LOD（Law Of Demeter）：一个对象（或者类）要对其他对象（或者类）保持最少的了解，又称最少知道原则。一个类只和他的直接朋友打交道，不和间接朋友打交道。直接朋友是指没得成员变量所属的类、方法入參类型和方法返回类型，至于方法内部用到的类型是间接朋友。
 *
 * @author zhangzhiwang
 * @date Feb 19, 2020 10:41:08 PM
 */
public class LOD {
	public static void main(String[] args) {
		// 需求：项目经理让一个员工统计订单的数量
		TeamLeader teamLeader = new TeamLeader();
		Employee employee = new Employee();
		
		teamLeader.command(employee);
	} 
}
