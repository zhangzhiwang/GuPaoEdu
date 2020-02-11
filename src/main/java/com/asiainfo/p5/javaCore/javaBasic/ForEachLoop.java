package com.asiainfo.p5.javaCore.javaBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * foreach循环是通过迭代器来实现的
 *
 * @author zhangzhiwang
 * @date 2020年2月10日 下午5:07:26
 */
public class ForEachLoop {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList();
		for(Integer i : list) {
			System.out.println(i);
		}
	}
}
