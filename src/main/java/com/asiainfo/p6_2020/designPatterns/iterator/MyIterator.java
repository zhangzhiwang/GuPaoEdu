package com.asiainfo.p6_2020.designPatterns.iterator;

/**
 * 抽象迭代器角色
 *
 * @author zhangzhiwang
 * @date 2020年4月5日 下午5:57:13
 */
public interface MyIterator<E> {
	E next();
	boolean hasNext();
}
