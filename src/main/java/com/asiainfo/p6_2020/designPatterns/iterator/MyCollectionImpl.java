package com.asiainfo.p6_2020.designPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class MyCollectionImpl<E> implements MyCollection<E>{
	private List<E> list;// 底层应该是个数组，这里为了演示用List意思一下
	

	public MyCollectionImpl() {
		this.list = new ArrayList<E>();
	}

	@Override
	public void add(E e) {
		list.add(e);
	}

	@Override
	public MyIterator<E> interator() {
		return new MyIteratorImpl<E>(list);
	}
}
