package com.asiainfo.lombok;

import java.util.Date;
import java.util.HashMap;

import lombok.val;

/**
 * val可以定义局部变量的类型，当不知道局部变量是啥类型的时候可以使用val来定义，val具体的类型以等号后面表达式的类型来确定。
 * 当不知道局部变量是啥类型的时候可以使用Object来接收，但是Object和val并不一样。用Object来接收相当于多态，比如Object o = new HashMap();
 * 但是val会被替换成突击的类型，比如val v1 = new HashMap();val会被替换成HashMap
 *
 * @author zhangzhiwang
 * @date 2021年3月12日 下午12:52:23
 */
public class ValTest {
//	private val v3 = new HashMap();// val只能用于基部变量不能用于全局变量
	
	public static void main(String[] args) {
		// 打开本类的class文件看一下
		val v1 = new HashMap();// 通过查看class文件可以看到val被替换成了HashMap
		v1.put("key", "value");
		System.out.println(v1);
		
		val v2 = new Date();
		System.out.println(v2);
	}
}
