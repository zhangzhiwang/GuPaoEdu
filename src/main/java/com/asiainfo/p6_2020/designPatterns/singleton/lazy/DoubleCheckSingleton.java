package com.asiainfo.p6_2020.designPatterns.singleton.lazy;

/**
 * 双重检查锁的单例模式，仍然是懒汉式
 *
 * @author zhangzhiwang
 * @date Mar 2, 2020 2:44:45 PM
 */
public class DoubleCheckSingleton {
	/**
	 * 用volatile修饰主要是防止指令重排序。</p>
	 * new一个对象的过程可以拆分成三条指令：</p>
	 * 1、在堆中开辟内存空间</p>
	 * 2、初始化对象</p>
	 * 3、将此对象的引用赋值给instance变量</p>
	 * 我们知道指令重来序是无依赖关系的指令之间进行的，在上面的三步中第一步和后面的两步都有依赖关系，所以不能参与重排序，但是2、3步之间是没有依赖关系的可以重排序。</p>
	 * 当2、3步重排序之后，一个线程在初始化之前先给instance变量赋值，这个时候另一个线程判断instance不为空就直接返回了，所以另一个线程可是会使用到尚未初始化过的对象。</p>
	 * 双重检查锁的优点：将锁粒度减小，从而减小了同步的范围使得大多数情况下获取instance实例无需同步，提高了性能。</p>
	 * 缺点：代码不优雅，如果不注意很可能少写一个判断
	 */
	private static volatile DoubleCheckSingleton instance;
	
	private DoubleCheckSingleton() {}
	
	public static DoubleCheckSingleton getInstance() {
		if(instance == null) {// 在instance不为null的情况下不需要任何同步措施，因为读和读是不互斥的，不会有线程安全问题。这样就减小了锁的粒度，使得在大部分情况下访问本方法是不需要同步的
			synchronized (DoubleCheckSingleton.class) {// 防止阻塞的线程恢复运行后其他线程在它阻塞期间已经创建过了对象，所以要再次判断一下
				if(instance == null) {
					instance = new DoubleCheckSingleton();
				}
			}
		}
		
		return instance;
	}
}
