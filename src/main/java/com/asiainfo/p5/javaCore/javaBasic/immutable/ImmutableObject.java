/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic.immutable;

import com.asiainfo.p5.javaCore.javaBasic.Son;

/**
 * 不可变类
 * </p>
 * 实现不可变类的步骤：
 * </p>
 * 1、该类被声明为final的，防止被继承（子类复写方法）

2、所有成员变量声明为private final的

3、不提供成员变量的setter方法

4、在构造方法初始化成员变量或者通过getter方法获取成员时，必须将成员变量进行深拷贝以防止引用外泄。注意：如果成员变量本身是不可变类性或者是基本类型则也不必要深拷贝


 *
 * @author Administrator
 * @date 2020年2月5日 下午10:09:21
 */
public final class ImmutableObject {
	private final Son SON;
	private final int NUM = 10;

	public ImmutableObject() {
		SON = new Son();
	}

	/**
	 * 使用深拷贝
	 * @param s
	 * @throws CloneNotSupportedException
	 */
	public ImmutableObject(Son s) throws CloneNotSupportedException {
//		this.SON = s;// 这样会导致外部持有该对象的引用修改Son对象
		this.SON = s.clone();
	}
	
	public Son getSon() throws CloneNotSupportedException {
//		return this.SON;// 这样会导致外部接收该方法返回值的对象持有内部Son引用导致引用外泄
		return this.SON.clone();
	}
}
