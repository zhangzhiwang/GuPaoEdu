package com.asiainfo;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import com.asiainfo.entity.User;

/**
 * 自定义对象工厂：需要实现ObjectFactory或者继承默认实现类DefaultObjectFactory
 *
 */
public class MyObjectFactory extends DefaultObjectFactory {
	private String key1;
	private int key2;
	
	/**
	 * 通过无參构造函数创建对象
	 */
	@Override
	public <T> T create(Class<T> type) {
		System.out.println("调用MyObjectFactory的create方法（无參构造函数）");
		T t = create(type, null, null);
		if(t instanceof User) {
			User user = (User) t;
			user.setInit("特殊处理：key1 = " + key1 + ",key2 = " + key2);// 可以对被创建的对象做一些特殊的操作，比如初始化等
		}
		
		return t;
	}

	/**
	 * 通过有參构造函数创建对象
	 */
	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		System.out.println("调用MyObjectFactory的create方法（有參构造函数）");
		return super.create(type, constructorArgTypes, constructorArgs);
	}

	/**
	 * 设置属性
	 */
	@Override
	public void setProperties(Properties properties) {
		this.key1 = (String) properties.get("url");
		this.key2 = Integer.parseInt((String) properties.get("port"));
	}

	/**
	 * 判断被创建的对象类是不是一个集合（是否属于Collection的子类）
	 */
	@Override
	public <T> boolean isCollection(Class<T> type) {
		return super.isCollection(type);
	}
}
