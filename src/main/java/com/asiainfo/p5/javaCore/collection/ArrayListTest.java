package com.asiainfo.p5.javaCore.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList——基于数组的List
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 8:01:41 PM
 */
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();// ArrayList的默认初始大小为10，每次扩容会扩0.5倍（即扩容后是原来容量的1.5倍）
		list.add(1);// ArrayList的数组是懒初始化的，在第一次添加数据的时候初始化的
	}
}
