package com.asiainfo.p6_2020.designPatterns.iterator;

import java.util.List;

/**
 * 具体迭代器实现角色</p>
 * 迭代器只负责遍历集合中的元素，不负责存储元素，存储元素是集合的事情
 *
 * @author zhangzhiwang
 * @date 2020年4月5日 下午6:04:50
 */
public class MyIteratorImpl<E> implements MyIterator<E> {
	private List<E> list;// 这个list不适用于存储元素的，因为next方法和hasNext方法都是无参的，所以必须要把整个集合传进来才能遍历里面的元素
	private int index;// 指针
	private E ele;// 集合中的元素
	
	
	public MyIteratorImpl(List<E> list) {
		super();
		this.list = list;
	}

	@Override
	public E next() {
		return list.get(index++);
	}

	@Override
	public boolean hasNext() {
		return index != list.size();
	}

}
