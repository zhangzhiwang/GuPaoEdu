package com.asiainfo.linkedList;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 深度拷贝带有随即指针的单向链表
 *
 * @author zhangzhiwang
 * @date 2021年4月7日 上午10:59:28
 */
public class DeepCopyRandomList {

	public Node copy(Node head) {
		// 1(2) -> 2(2) -> 3(5) -> 4 -> 5(1) -> 6(2)
		if(head == null) {
			return null;
		}
		
		return null;
	}

	@RequiredArgsConstructor
	@NoArgsConstructor
	static class Node {
		@NonNull
		Object data;
		Node next;
		Node random;
	}
}
