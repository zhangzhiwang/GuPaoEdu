package com.asiainfo.p6_2020.designPatterns.flyweight;

/**
 * 享元模式——避免创建大量相似或者相同的对象而过多占用内存，将一部分对象放在一个容器里，用的时候去里面取，用完再归还回去，平时常见的各种“池”就是享元模式的应用	
 *
 * @author zhangzhiwang
 * @date Mar 21, 2020 8:50:08 PM
 */
public class FlyweightTest {
	public static void main(String[] args) {
		MyConnectionFactory.getConnection("c1");
		MyConnectionFactory.getConnection("c1");
		MyConnectionFactory.getConnection("c1");
		MyConnectionFactory.getConnection("c2");
		
		// 享元模式的三个角色：享元抽象类、享元实现类、享元工厂
		// 享元模式和注册式单例模式的区别：享元模式同一个类可以有多个对象，而注册式单例模式同一个类只能有一个对象
		/**
		 * 享元模式在生活中的例子：共享单车。首先共享单车不是单例的，摩拜不可能全国就一个单车，但是全国每个人都买一辆单车又有点浪费，不如谁需要骑车谁就去借，用完之后再还回去。</p>
		 * 享元模式在源码中的例子：</p>
		 * 1、String常量池，避免过多创建同一个字符串常量，如果没有某一个常量就创建一个然后放到常量池里面，再次用到的时候直接从常量池里面取。</p>
		 * 2、Integer缓存，查看Integer的源码会发现它是存在缓存的，如果在一定范围（-128～127）内的整数值是从缓存内取得，超出这个范围就直接创建新对象了。
		 */
		
		Integer i1 = Integer.valueOf("127");
		Integer i2 = 127;
		System.out.println(i1 == i2);// true
		
		Integer i3 = Integer.valueOf("128");
		Integer i4 = 128;
		System.out.println(i3 == i4);// false
	}
}
