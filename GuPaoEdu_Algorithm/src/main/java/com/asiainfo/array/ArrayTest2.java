package com.asiainfo.array;

import java.util.Iterator;

/**
 * 数组高级操作——插入元素：在一个无序数组中插入一个元素
 *
 * @author zhangzhiwang
 * @date 2021年7月27日 上午10:11:53
 */
public class ArrayTest2 {
	public static void main(String[] args) {
		// 倒序遍历数组
		Integer[] is = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		for (int i = is.length - 1; i >= 0; i--) {
			System.out.print(is[i] + "\t");
			
		}
		System.out.println();
		
		// 遍历数组指定区间的元素
		int indexStart = 3;
		int indexEnd = 7;
		for (int i = indexStart; i <= indexEnd; i++) {
			System.out.print(is[i] + "\t");
		}
		System.out.println();
		
		// 倒叙遍历数组指定区间的元素
		for (int i = indexEnd; i >= indexStart; i--) {
			System.out.print(is[i] + "\t");
		}
		System.out.println();
		
		// 指定位置插入元素
		System.out.println("-------------");
		int size = 0;// 保存数组实际存放元素的个数（注意不是初始化长度）
		Integer[] is2 = new Integer[10];// 初始化10个长度
		for (int i = 0; i < 8; i++) {// 插入8个元素
			is2[i] = i + 1;
			size++;
		}
		System.out.println("数组实际存放元素的个数：" + size);
		for (int i = 0; i < is2.length; i++) {
			System.out.print(is2[i] + "\t");
		}
		System.out.println();
		
//		Integer[] result = insertAnElement(new Integer[10], 0, 0, 100);// 前序遍历
		Integer[] result = insertAnElement2(is2, 8, 8, 100);// 后序遍历
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "\t");
		}
		System.out.println();
	}
	
	/**
	 * 指定位置插入元素（前序遍历）
	 * 
	 * @param arr	数组
	 * @param size	数组实际存放元素的个数
	 * @param index	被插入元素的位置下标
	 * @param element	被插入的元素
	 * @author zhangzhiwang
	 * @date 2021年7月27日 下午12:21:16
	 */
	private static Integer[] insertAnElement(Integer[] arr, int size, int index, int element) {
		if(arr == null) {
			throw new RuntimeException("数组为空！");
		}
		if(size < 0 || size >= arr.length) {
			throw new RuntimeException("数组已满！");
		}
		
		if(index < 0 || index > size) {
			throw new RuntimeException("index越界！");
		}
		
		if(index == size) {// 说明是最后一个元素，直接赋值无需移动
			arr[index] = element;
			return arr;
		}
		
		// 解法1:前序遍历
		// index在中间的情况，前序遍历。整体后移的思路：要保存两个临时节点，一个是指定节点，一个是指定节点的下一个节点，然后让后面的每一个节点都等于前面的节点
		Integer tmp = arr[index];// 保存指定节点
		Integer tmpNext = 0;// 保存指定节点的下一个节点
		for (int i = index; i < size; i++) {// 将index位置后面的所有元素后移一个位置
			tmpNext = arr[i + 1];// 把原来的index位置后面的元素（即index+1位置的元素）临时保存起来
			arr[i + 1] = tmp;
			tmp = tmpNext;
		}
		// 最后给index的位置赋新值
		arr[index] = element;
		
		return arr;
	}
	
	/**
	 * 指定位置插入元素（后序遍历）
	 * 
	 * @param arr	数组
	 * @param size	数组实际存放元素的个数
	 * @param index	被插入元素的位置下标
	 * @param element	被插入的元素
	 * @author zhangzhiwang
	 * @date 2021年7月27日 下午12:21:16
	 */
	private static Integer[] insertAnElement2(Integer[] arr, int size, int index, int element) {
		if(arr == null) {
			throw new RuntimeException("数组为空！");
		}
		if(size < 0 || size >= arr.length) {
			throw new RuntimeException("数组已满！");
		}
		
		if(index < 0 || index > size) {
			throw new RuntimeException("index越界！");
		}
		
		if(index == size) {// 说明是最后一个元素，直接赋值无需移动
			arr[index] = element;
			return arr;
		}
		
		// 解法2:后续遍历
		// 后续遍历的代码更加简洁，一行代码搞定，不需要像前序遍历那样保存两个临时变量。
		for (int i = size - 1; i >= index; i--) {
			arr[i + 1] = arr[i];
			size++;
		}
		// 最后给index的位置赋新值
		arr[index] = element;
		
		return arr;
	}
}
