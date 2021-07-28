package com.asiainfo.array;

import java.util.Iterator;

/**
 * 数组高级操作——删除元素
 *
 * @author zhangzhiwang
 * @date 2021年7月27日 上午10:11:53
 */
public class ArrayTest4 {
	public static void main(String[] args) {
		Integer[] is = new Integer[10];
		int size = 0;
		for (int i = 0; i < 10; i++) {
			is[i] = i + 10;
			size++;
		}

		for (int i = 0; i < is.length; i++) {
			System.out.print(is[i] + "\t");
		}
		System.out.println();

//		Integer[] result = deleteAnElementByIndex(is, 8, 7);
//		Integer[] result = deleteAnElementByIndex(new Integer[] {1}, 1, 0);

//		Integer[] result = deleteAnElementByValue(is, 8, 12);
		Integer[] result = deleteAnElementByValue2(new Integer[] { 10, 11, 12, 11, 14, 15, 16, 17, 18, 19 }, 10, 11);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "\t");
		}
		System.out.println();
	}

	/**
	 * 数组删除元素——根据指定位置删除
	 * 
	 * @param arr
	 * @param size
	 * @param index 被删除元素的索引
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年7月28日 下午3:28:48
	 */
	private static Integer[] deleteAnElementByIndex(Integer[] arr, int size, int index) {
		if (arr == null || size <= 0) {
			throw new RuntimeException("数组已空！");
		}

		if (index < 0 || index >= size) {
			throw new RuntimeException("index err!");
		}

		for (int i = index; i < size; i++) {
			if (i == size - 1) {
				arr[i] = null;
				break;
			}
			arr[i] = arr[i + 1];
		}

		size--;// 不要忘了最后size减1
		return arr;
	}

	/**
	 * 数组删除元素——根据元素值删除第一个相匹配的元素
	 * 
	 * @param arr
	 * @param size
	 * @param element 被删除的元素
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年7月28日 下午4:39:34
	 */
	private static Integer[] deleteAnElementByValue(Integer[] arr, int size, Integer element) {
		if (arr == null || size <= 0) {
			throw new RuntimeException("数组已空！");
		}

		boolean flag = true;// 这里的目的是只删除第一个匹配的元素
		for (int i = 0; i < size; i++) {
			if (element != arr[i] && flag) {
				continue;
			}

			if (i == size - 1) {
				arr[i] = null;
			} else {
				arr[i] = arr[i + 1];
				flag = false;
			}
		}

		size--;
		return arr;
	}
	
	/**
	 * 数组删除元素——根据元素值删除所有相匹配的元素
	 * 
	 * @param arr
	 * @param size
	 * @param element 被删除的元素
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年7月28日 下午4:39:34
	 */
	private static Integer[] deleteAnElementByValue2(Integer[] arr, int size, Integer element) {
		// TODO zzw 未实现
		return arr;
	}

//	public static void main(String[] args) {
//		int[] arr = new int[10];
//		int size = 10;
//		for (int i = 0; i < size; i++)
//			arr[i] = i + 10;
//		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + "\t");
//		}
//		System.out.println();
//
//		remove(arr, 10, 3);
//		for (int i = 0; i < 10; i++)
//			System.out.print(arr[i] + " ");
//	}
//
//	public static int remove(int[] arr, int size, int index) {
//		if (index < 0 || index >= size)
//			throw new IllegalArgumentException("Remove failed. Index is illegal.");
//
//		int ret = arr[index];
//		for (int i = index + 1; i < size; i++)
//			arr[i - 1] = arr[i];
//		size--;
//		return ret;
//	}
}
