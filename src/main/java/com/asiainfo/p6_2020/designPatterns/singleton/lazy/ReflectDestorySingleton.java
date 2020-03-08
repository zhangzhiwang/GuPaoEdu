package com.asiainfo.p6_2020.designPatterns.singleton.lazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import com.asiainfo.p6_2020.designPatterns.singleton.hungry.HungrySingleton1;

/**
 * 反射破坏单例
 *
 * @author zhangzhiwang
 * @date Mar 4, 2020 11:01:08 AM
 */
public class ReflectDestorySingleton {
	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) throws Exception {
		Class clazz = HungrySingleton1.class;
		Constructor constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		Field field = clazz.getDeclaredField("instance");
		field.setAccessible(true);
		field.set(null, null);
		Object object1 = constructor.newInstance();
		System.out.println(object1);
		
		Object object2 = constructor.newInstance();
		System.out.println(object2);
		System.out.println(object1 == object2);
	}
}
