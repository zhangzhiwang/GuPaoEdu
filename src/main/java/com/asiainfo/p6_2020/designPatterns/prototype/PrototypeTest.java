package com.asiainfo.p6_2020.designPatterns.prototype;

/**
 * 原型模式——说白了就是通过原有对象克隆出一个新对象
 *
 * @author zhangzhiwang
 * @date Mar 8, 2020 10:12:11 PM
 */
public class PrototypeTest {
	public static void main(String[] args) {
		// 原型模式说白了就是深拷贝，没别的 
		
		/**
		 * 原型模式的使用场景：</p>
		 * 1、构造方法里面的逻辑很复杂且很耗时，可以使用原型模式，因为对象的拷贝不会调用构造方法</p>
		 * 2、当一个对象有很多属性的时候，如果想创建一个相似的对象出来，那么就可以使用原型模式先克隆一个出来然后再修改个别属性，以防止过多地调用set/get方法导致代码可读性下降</p>
		 * 3、当一个对象需要被不同的调用者使用，并且不同的调用者会修改不同属性的值且互不干扰，可以使用原型模式
		 */
	}
}
