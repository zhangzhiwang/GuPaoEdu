package com.asiainfo.p6_2020.designPatterns.singleton.lazy;

/**
 * 懒汉式单例模式——在第一次需要时才初始化对象</p>
 * 优点：解决了饿汉式单例模式在类加载时初始化对象导致的内存浪费问题，如果加上synchronized关键字保证了线程安全问题</p>
 * 缺点：synchronized家在方法定义处效率低。只有在第一次新建对象时才需要同步，对象建好后绝大部分的场景都是获取该对象，而获取对象是不需要同步的。改进方案就是缩小锁粒度，于是就出现类双重检查锁的单例模式。
 *
 * @author zhangzhiwang
 * @date Mar 2, 2020 2:34:16 PM
 */
public class LazySingleton1 {
	private static LazySingleton1 instace;
	
	private LazySingleton1() {}
	
	public static synchronized LazySingleton1 getInstance() {
		if(instace == null) {
			instace = new LazySingleton1();
		}
		
		return instace;
	}
}
