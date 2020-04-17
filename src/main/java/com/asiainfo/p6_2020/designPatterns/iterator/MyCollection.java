package com.asiainfo.p6_2020.designPatterns.iterator;

/**
 * 抽象集合角色
 *
 * @author zhangzhiwang
 * @date 2020年4月5日 下午6:00:02
 */
public interface MyCollection<E> {
	void add(E e);
	MyIterator<E> interator();
}
