package com.asiainfo.p6.designPatterns.singleton;

/**
 * 双重检验懒汉式单例模式
 *
 * @author zhangzhiwang
 * @date Oct 28, 2019 1:13:14 PM
 */
public class DoubleCheckLazySingleton {
	private static volatile DoubleCheckLazySingleton doubleCheckLazySingleton;// 防止指令重排序

	private DoubleCheckLazySingleton() {
	}

	// 传统懒汉式写法
	public static synchronized DoubleCheckLazySingleton getInstanceOld() {
		if (doubleCheckLazySingleton != null) {// 传统懒汉式写法是将synchronized关键字放在方法的定义处，这样做可以保证线程安全问题，但是会有性能问题，因为锁的粒度比较大。其实当doubleCheckLazySingleton不为空时返回该变量所指向的实例这段逻辑完全不需要同步，不存在线程安全问题。
												// 因为单例模式只会创建一回实例，大部分的场景是：多个线程来判断doubleCheckLazySingleton是否为空时大部分时候是不为空的，直接返回实例即可，这个没有线程安全问题，就是说getInstance方法大部分是不需要同步的。
												// 而synchronized关键字修饰getInstance方法的定义，每次调用该方法都需要同步，势必会影响效率，只有在真正创建实例的那部分才需要同步。所以优化的方法就是减小锁的粒度，用synchronized代码块的方式。
			return doubleCheckLazySingleton;
		}

		doubleCheckLazySingleton = new DoubleCheckLazySingleton();// 会有指令重排序
		return doubleCheckLazySingleton;
	}

	public static DoubleCheckLazySingleton getInstance() {
		// 双重检验锁
		if (doubleCheckLazySingleton == null) {// 外面的if判断是不需要加锁的，就像上面分析的一样，大部分情况下都不会进入这个判断，直接返回实例，所以提高了性能
			synchronized (DoubleCheckLazySingleton.class) {
				if (doubleCheckLazySingleton == null) {// 里面的if判断是避免多个线程进入同步代码块后重复实例化对象
					/**
					 * new一个对象实际上分为三步：</p>
					 * 1、在堆里面开辟内存空间</p>
					 * 2、初始化对象</p>
					 * 3、把堆内存地址赋给栈中的变量</p>
					 * 由于JVM的指令重排序，第2、3步可能颠倒顺序，因为这两部没有关联关系。如果出现了重排序，那么在多线程环境下就肯能出现问题：</p>
					 * 加入线程1进入了同步块进行new对象的动作，JMV把第2和第3步颠倒，那么在执行完第三步的时候，变量已经不为空了但是还没有初始化，线程2在进入外层判断的时候发现变量不为空就直接返回了，但实际上还没有初始化，就会出现问题，所以要在变量定义的地方加上volatile关键字防止指令冲排序
					 */
					doubleCheckLazySingleton = new DoubleCheckLazySingleton();
				}
			}
		}

		return doubleCheckLazySingleton;
	}
}
