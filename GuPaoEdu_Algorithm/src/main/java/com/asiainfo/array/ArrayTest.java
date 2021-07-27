package com.asiainfo.array;

import java.util.Iterator;

/**
 * 数组基本操作
 *
 * @author zhangzhiwang
 * @date 2021年7月27日 上午10:11:53
 */
public class ArrayTest {
	public static void main(String[] args) {
		// 创建数组
		int[] is = new int[10];

		// 初始化数组（元素值是连续的）
		for (int i = 0; i < is.length; i++) {
			is[i] = i + 1;
		}

		// 遍历
		for (int i = 0; i < is.length; i++) {
			System.out.print(is[i] + "\t");
		}
		System.out.println();
		
		// 初始化数组方式二（元素值不连续）
		int[] is2 = new int[] { 1, 2, 3, 5, 6, 7, 8, 9 };
		System.out.println("is2.length = " + is2.length);
		
		for (int i = 0; i < is2.length; i++) {
			System.out.print(is2[i] + "\t");
		}
		System.out.println();
		
		/*
		 * 注意：数组的长度是定义数组时确定的，而不是实际往里面存放元素的个数。实际上，数组定义时初始化的大小有多大，实际上就会存放多少个元素并且全是默认值，
		 * 换句话说当定义一个数组时指定的长度是10，那么会在jvm的堆中开辟10个单位的连续空间并给这10个元素赋默认值，当手动赋值时会覆盖掉初始的默认值。
		 */
		int[] is3 = new int[10];
		System.out.println("初始化时已经给所有元素赋默认值：");
		for (int i = 0; i < is3.length; i++) {
			System.out.print(is3[i] + "\t");
		}
		System.out.println();

		// 初始化数组（元素值是连续的）
		for (int i = 0; i < 8; i++) {
			is3[i] = i + 1;
		}

		// 遍历
		System.out.println("is3.length = " + is3.length);
		for (int i = 0; i < is3.length; i++) {
			System.out.print(is3[i] + "\t");
		}
		System.out.println();
		
		// 测试数组初始化时会给所有元素赋默认值
		System.out.println("测试数组初始化时会给所有元素赋默认值：");
		boolean[] bs = new boolean[5];
		for (int i = 0; i < bs.length; i++) {
			System.out.print(bs[i] + "\t");
		}
		System.out.println();
		
		bs[2] = true;
		for (int i = 0; i < bs.length; i++) {
			System.out.print(bs[i] + "\t");
		}
		System.out.println();
		
		System.out.println("------------------");
		// 通过索引查找元素
		int element = searchElementByIndex(is, 0);
		System.out.println("通过索引查找元素：" + element);
		
		// 通过元素查找索引
		int index = searchIndexByElement(is, 1);
		System.out.println("通过元素查找索引：" + index);
	}
	
	/**
	 * 通过索引查找元素
	 * 
	 * @param arr
	 * @param index
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年7月27日 上午10:33:46
	 */
	private static int searchElementByIndex(int[] arr, int index) {
		// 边界值判断
		if(index < 0 || index > arr.length - 1) {
			throw new RuntimeException("index err!");
		}
		return arr[index];
	}
	
	/**
	 * 通过元素查找索引
	 * 
	 * @param arr
	 * @param element
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年7月27日 上午10:40:18
	 */
	private static int searchIndexByElement(int[] arr, int element) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == element) {
				return i;
			}
		}
		return -1;
	}
}
