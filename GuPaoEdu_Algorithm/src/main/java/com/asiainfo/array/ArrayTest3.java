package com.asiainfo.array;

import java.util.Iterator;

/**
 * 数组高级操作——插入元素：在一个有序数组中插入一个元素
 *
 * @author zhangzhiwang
 * @date 2021年7月27日 上午10:11:53
 */
public class ArrayTest3 {
	public static void main(String[] args) {
		Integer[] is = new Integer[10];
		int size = 0;
		for (int i = 0; i < 8; i++) {// 一个倒序排好序的数组
			is[i] = 8 - i;
			size++;
		}

		System.out.println("初始size = " + size);
		for (int i = 0; i < is.length; i++) {
			System.out.print(is[i] + "\t");
		}
		System.out.println();

		is = new Integer[] { 10, 8, 6, 4, 2, 0, null, null };
//		is = new Integer[] { 0, 1, 2, 4, 5, null, null };
		Integer[] result = insertAnElementSort2(is, 6, 7);
//		Integer[] result = add(is, 5, 6);

		System.out.println("插入元素后size = " + size);
		for (int i = 0; i < is.length; i++) {
			System.out.print(is[i] + "\t");
		}
		System.out.println();
	}
	
//	public static void main(String[] args) {
//
//		Integer[] arr = new Integer[10];
//        int size = 9;
//        for (int i = 0; i < size; i++)
//            arr[i] = i;
//       
//        for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + "\t");
//		}
//        System.out.println();
//        
//        add(arr, size, 9);
//        for (int i = 0; i < 10; i++){
//               System.out.print(arr[i] + " ");
//       }
//    
// }

	/**
	 * 在一个有序数组中插入一个元素
	 * </p>
	 * 解法1:先找位置再移动元素
	 * 
	 * @param arr     要求数组前面的N个位置都是连续有值的，不能中间穿插null
	 * @param size
	 * @param element
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年7月28日 上午11:12:45
	 */
	private static Integer[] insertAnElementSort(Integer[] arr, int size, Integer element) {
		if (arr == null) {
			throw new RuntimeException("数组为空！");
		}

		if (size < 0 || size >= arr.length) {
			throw new RuntimeException("数组已满！");
		}

		// 找到element应该被插入的位置
		int index = 0;// 元素应该被插到index位置上
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				index = size;
				break;
			}
			if (element >= arr[i]) {// 注意传进来的数组是倒序排好序的
				index = i;
				break;
			}
		}

		// 挪动index后面所有的元素
		for (int i = size - 1; i >= index; i--) {
			arr[i + 1] = arr[i];
		}

		// index位置上
		arr[index] = element;
		size++;

		return arr;
	}

	/**
	 * 在一个有序数组中插入一个元素
	 * </p>
	 * 解法2:从后面遍历，一边遍历一边判断，不需要事先找到被插入元素的位置
	 * 
	 * @param arr     要求数组前面的N个位置都是连续有值的，不能中间穿插null
	 * @param size
	 * @param element
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年7月28日 上午11:12:45
	 */
	private static Integer[] insertAnElementSort2(Integer[] arr, int size, Integer element) {
		if (arr == null) {
			throw new RuntimeException("数组为空！");
		}

		if (size < 0 || size >= arr.length) {
			throw new RuntimeException("数组已满！");
		}

		for (int i = size - 1; i >= 0; i--) {
			if (element >= arr[i]) {
				arr[i + 1] = arr[i];
				if (i == 0) {
					arr[i] = element;
					size++;
					break;
				}
				continue;
			}

			arr[i + 1] = element;
			size++;
			break;
		}

		return arr;
	}

//	public static Integer[] add(Integer[] arr, int size, int element) {
//		if (size == arr.length)
//			throw new IllegalArgumentException("Add failed. Array is full.");
//		int index = -1;
//		// 找到新元素的插入位置
//		for (int i = 0; i < size; i++) {
//			if (element < arr[i]) {
//				index = i;
//				break;
//			}
//		}
//		// 元素后移
//		for (int j = size - 1; j > index; j--) {
//			arr[j] = arr[j - 1];
//		}
//		// 插入数据
//		arr[index] = element;
//		size++;
//		return arr;
//	}
}
