package com.asiainfo.p6_2020.designPatterns.iterator;

/**
 * 迭代器模式——将集合的遍历抽象成统一的接口从而像客户端屏蔽了结合的内部结构，是客户端调用这个统一的接口遍历集合即可而无需关心不同集合底层的数据结构是什么。</p>
 * 如果不使用迭代器模式，那么各种集合实现都必须提供迭代自己存储元素的方法，而客户端需要根据不同的集合调用不同的迭代方法。迭代器模式就是将各种集合的迭代行为抽取出来放到迭代器里面，迭代器对外提供统一的迭代接口。</p>
 * 迭代器模式的角色：</p>
 * 1、抽象迭代器角色</p>
 * 2、具体迭代器实现</p>
 * 3、抽象集合角色</p>
 * 4、具体集合实现类
 *
 * @author zhangzhiwang
 * @date 2020年4月5日 下午5:39:48
 */
public class IteratorTest {
	public static void main(String[] args) {
		User u1 = new User("zs");
		User u2 = new User("ls");
		User u3 = new User("ww");
		
		MyCollectionImpl<User> myCollectionImpl = new MyCollectionImpl<User>();
		myCollectionImpl.add(u1);
		myCollectionImpl.add(u2);
		myCollectionImpl.add(u3);
		
		// 使用自定义迭代器迭代自定义集合
		MyIterator<User> myIterator = myCollectionImpl.interator();
		while(myIterator.hasNext()) {
			User user = myIterator.next();
			System.out.println(user);
		}
		
		/**
		 * 迭代器模式在源码中的应用：Iterator接口和各种集合
		 */
	}
}
