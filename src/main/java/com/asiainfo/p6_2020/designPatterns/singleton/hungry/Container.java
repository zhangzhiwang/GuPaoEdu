package com.asiainfo.p6_2020.designPatterns.singleton.hungry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册式单例模式——该单例模式是Spring对枚举式单例模式的优化
 * 缺点：</p>
 * 1、反射不安全，可以通过反射替换掉map里面的某个对象。
 * 2、线程不安全，多线程下确实能保证map里面的对象都是单例的，但是会存在偷梁换柱的现象——线程1创建了一个对象放到了map里，线程2又创建了一个对象放到了map里，虽然该对象在map里的总数是一个，最先创建的对象已经被替换掉了。
 *
 * @author zhangzhiwang
 * @date Mar 4, 2020 3:50:44 PM
 */
public class Container {
	private static Map<String, Object> map = new ConcurrentHashMap<String, Object>();
	
	private Container() {}// Container类似于工具类，不需要创建对象所以私有化构造器
	
	public static Object getInstance(String fullClassName) {
		Object object = null;
		if(map.containsKey(fullClassName)) {
			object = map.get(fullClassName); 
		} else {
			try {
				synchronized (Container.class) {// 解决注册式单例模式线程不安全问题
					if(map.containsKey(fullClassName)) {
						object = map.get(fullClassName); 
					} else {
						object = Class.forName(fullClassName).newInstance();
						map.put(fullClassName, object);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return object;
	}
}
