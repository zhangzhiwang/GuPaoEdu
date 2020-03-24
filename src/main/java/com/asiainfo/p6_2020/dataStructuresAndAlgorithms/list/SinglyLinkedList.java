package com.asiainfo.p6_2020.dataStructuresAndAlgorithms.list;

/**
 * 单向链表
 *
 * @author zhangzhiwang
 * @date Mar 24, 2020 2:06:35 PM
 */
public class SinglyLinkedList<T> {
	private T head;

	static class Node<T> {
		private T t;
		private T next;

		public Node(T t, T next) {
			super();
			this.t = t;
			this.next = next;
		}

		public Node() {
			super();
		}
	}
	
	/**
	 * 从头部插入一个节点（头插法）
	 * 
	 * @param t
	 * @author zhangzhiwang
	 * @date Mar 24, 2020 2:09:51 PM
	 */
	public void addFromHead(T t) {
		
	}
}
