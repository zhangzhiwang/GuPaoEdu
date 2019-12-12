package com.asiainfo.p5.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型</p>
 * 泛型是什么？泛型可以理解为广泛的类型，就是它可以将参数的类型参数化，因此它也叫参数类型或者类型参数。</p>
 * 什么是泛型类型擦除？首先，泛型是jdk1.5才出现的功能，为了兼容1.5之前的代码，那么在运行期间需要将泛型去除还原它的本来面目。它的本来面目是什么？如果在定义泛定的时候没有指定它的上限类型，那么泛型类型擦除后泛型会还原成Object类型；如果在定义泛型时指定了它的上线类型（比如<T extends Number>），那么类型擦除后会还原成Number；</p>
 * 如果在定义泛型时指定了多个上限类型（比如<T extends Number,Thread>），则在擦除后会还原成第一个上限类型（即Number）。
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 1:25:52 PM
 */
public class GenericTest {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<String> list2 = new ArrayList<String>();
		System.out.println(list1.getClass().getName());
		System.out.println(list2.getClass().getName());
		System.out.println(list1.getClass() == list2.getClass());// 泛型类型擦除
	}
}
