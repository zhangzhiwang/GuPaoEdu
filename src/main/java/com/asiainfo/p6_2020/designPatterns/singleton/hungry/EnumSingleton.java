package com.asiainfo.p6_2020.designPatterns.singleton.hungry;

/**
 * 基于枚举的单例模式
 *
 * @author zhangzhiwang
 * @date Mar 4, 2020 12:56:03 PM
 */
public enum EnumSingleton {// 任何一个枚举类都隐式继承了java.lang.Enum
	/**
	 *  枚举类在加载的时候就将定义的对象初始化好并作为value存到java.lang.Enum的HashMap中，所以基于枚举的单例模式属于饿汉式单例，饿汉式天生具有线程安全的特性，类加载完成之后线程只能读而不能写。</p>
	 *  java的反射机制在Class的newInstance()方法里面就限制了如果该类是一个枚举类那么不能通过反射创建对象，所以基于枚举的单例模式天生也是反射安全的。而且反序列化破坏不了单例。
	 */
	SINGLETON;// 枚举类只定义一个实例
	
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public static EnumSingleton getInstance() {
		return SINGLETON;
	}
}
