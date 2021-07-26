package com.asiainfo.linkedList;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 反转单向链表
 *
 * @author zhangzhiwang
 * @date 2021年3月31日 下午1:41:49
 */
public class ReverseLinkedList {
	public static void main(String[] args) {
		// 构造一个单项链表：1-2-3-4-5-6-7-8-9-10
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;

		Node next = node1;
		do {
			System.out.print(next.data);
			next = next.next;
			if (next != null) {
				System.out.print(" -> ");
			}
		} while (next != null);

		System.out.println();
		
//		Node n = reversewholeLinkedList(node1);
		Node n = reverseRangeLinkedList(node1, 1, 2);
		next = n;
		do {
			System.out.print(next.data);
			next = next.next;
			if (next != null) {
				System.out.print(" -> ");
			}
		} while (next != null);
	}

	/**
	 * 反转整个单向链表
	 * 
	 * @param head
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年3月31日 下午1:56:52
	 */
	public static Node reversewholeLinkedList(Node head) {
		// 1 -> 2 -> 3 -> 4 -> 5
		if(head == null || head.next == null) {// 没有节点或者只有一个头节点
			return head;
		}
		
		Node pre = null;
		Node current = head;
		Node post = null;
		while(current != null) {
			post = current.next;// 临时保存下一节点，方便后续使用
			current.next = pre;// 将下一节点的指针域指向前一节点
			
			// 整体后移
			pre = current;
			current = post;
		}
		
		return pre;// 返回新链表的头节点，即原链表的尾节点
	}
	
	/**
	 * 反转链表区间[m,n]的节点
	 * 
	 * @param head
	 * @param m m从1开始
	 * @param n
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年4月6日 下午7:46:35
	 */
	public static Node reverseRangeLinkedList(Node head, int m, int n) {
		/**
		 *  1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
		 *      preM  M					  N  postN
		 *  思路：m到n和上面反转整个链表一样，然后preM.next指向原来的N，原来的M.next指向postN。
		 *  为了防止M是head（这样preM就是null了），需要设置一个虚的“哨兵节点dummy”作为preM，并将dummy.next指向head，这样整个链表的头节点是dummy.next
		 */
		if(head == null || head.next == null || m >= n) {
			return head;
		}
		
		// 设置哨兵节点
		Node dummy = new Node();
		dummy.next = head;
		
		Node preM = dummy;
		Node nodeM = null;
		Node nodeN = null;
		Node postN = null;
		
		// 找到preM
		for(int i = 1; i < m; i++) {
			preM = preM.next;
		}
		
		nodeM = preM.next;
		postN = nodeM;
		// 找到postN
		for(int i = m; i <= n; i++) {
			postN = postN.next;
		}
		
		// 反转链表从m到n
//		Node pre = null;
		Node current = nodeM;
		Node post = null;
		while(current != postN) {
			post = current.next;// 临时保存下一节点，方便后续使用
			
			post.next = current;// 将下一节点的指针域指向前一节点
			
			// 整体后移
			current = post;
		}
		
		// 反转后pre就是nodeN，current就是postN，将preM.next指向pre，将nodeM.next指向current
		preM.next = current;
		nodeM.next = postN;
		
		return head;
	}
	
	/**
	 * 单向链表结构——节点
	 *
	 * @author zhangzhiwang
	 * @date 2021年3月31日 下午1:43:13
	 */
	@NoArgsConstructor
	@RequiredArgsConstructor
	static class Node {
		@NonNull
		public Object data;
		public Node next;
	}
}
