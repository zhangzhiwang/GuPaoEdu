package com.asiainfo.p5.javaCore.reflect;

import java.lang.reflect.Field;
import java.util.logging.Logger;

/**
 * Java反射机制——字段的反射
 *
 * @author zhangzhiwang
 * @date Dec 6, 2019 5:44:18 PM
 */
public class FieldReflectTest extends Boy {
	public static final Logger LOG = Logger.getLogger("com.asiainfo.p5.javaCore.reflect.IPerson");
	public int aaa;
	int bbb;
	private String ccc;
	private static String ddd;

	public void crtMet1() {
	}

	protected String crtMet2(String name) {
		return null;
	}

	int crtMet3() {
		return 0;
	}

	private void crtMet4(int age) {
	}

	private static void crtMet5() {
	}

	public static final void crtMet6() {
	}

	public static void main(String[] args) {
		Class clazz = FieldReflectTest.class;
		Field[] fields = clazz.getFields();// 获取该类及其所有父类的公共字段
		System.out.println(fields.length);
		for(Field field : fields) {
			System.out.println(field);
		}
		System.out.println("----------------");
		
		Field[] declaredFields = clazz.getDeclaredFields();// 获取本类声明的（Declared）所有字段，包括本类任意访问控制符的字段但不包括父类的任何字段
		System.out.println(declaredFields.length);
		for(Field field : declaredFields) {
			System.out.println(field);
		}
		System.out.println("----------------");
		
		try {
			Field field = clazz.getField("LOG");// 注意：不是获取制定名称的字段，而是获取制定名称的公有（public）字段
			System.out.println(field);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------");
		
		try {
			Field declaredField = clazz.getDeclaredField("ccc");// 获取本类声明的任意访问控制符的指定字段
			System.out.println(declaredField);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------");
		
		try {
			Field declaredField = clazz.getDeclaredField("LOG");
			int modifiers = declaredField.getModifiers();
			System.out.println(modifiers);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		System.out.println("----------------");
		
		// 反射可以访问其他类的private字段，前提是设置字段的可见性为true
		try {
			Boy boy = new Boy();
			Field declaredField = Boy.class.getDeclaredField("age");
			System.out.println(declaredField);
			declaredField.setAccessible(false);// 如果不设置字段的accessible为true，那么反射也不能访问其他类的私有字段。但是如果把一个public字段的accessible设为false，则照样能够访问。
			declaredField.set(boy, 112);
//			System.out.println(boy.getMoney());
			System.out.println(boy.age);
			
			Field declaredField2 = Boy.class.getDeclaredField("desc");
			declaredField2.set(null, "This is desc.");
			System.out.println(Boy.desc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
