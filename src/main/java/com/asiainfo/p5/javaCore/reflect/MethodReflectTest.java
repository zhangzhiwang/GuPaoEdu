package com.asiainfo.p5.javaCore.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * Java反射机制——方法的反射
 *
 * @author zhangzhiwang
 * @date Dec 6, 2019 5:44:18 PM
 */
public class MethodReflectTest extends Boy {
	private int age;

	public MethodReflectTest() {
	}

	public MethodReflectTest(int age) {
		super();
		this.age = age;
	}

	public void crtMet1() {
	}

	public void crtMet1(String s, int i) {
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
		System.out.println("crtMet5");
	}

	public static final void crtMet6() {
	}

	public static void main(String[] args) {
		Class<MethodReflectTest> clazz = MethodReflectTest.class;
		Method[] methods = clazz.getMethods();// 获取本类及其所有父类的公共方法，注意不包括构造方法
		System.out.println(methods.length);
		for (Method method : methods) {
			System.out.println(method);
		}
		System.out.println("----------------");

		Method[] declaredMethods = clazz.getDeclaredMethods();// 获取本类声明的所有方法，不包括构造方法
		System.out.println(declaredMethods.length);
		for (Method method : declaredMethods) {
			System.out.println(method);
		}
		System.out.println("----------------");

		try {
//			Method method = clazz.getMethod("crtMet1");
			Method method = clazz.getMethod("boyMet1", String.class, int.class);// 获取本类或者父类指定的公有方法
			System.out.println(method);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------");

		try {
//			Method method = clazz.getMethod("crtMet1");
			Method method = clazz.getDeclaredMethod("crtMet1", String.class, int.class);// 获取本类或者父类指定的公有方法
			System.out.println(method);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------");

		try {
			Method method = clazz.getDeclaredMethod("crtMet6");
			int modifiers = method.getModifiers();
			System.out.println(modifiers);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------");

		try {
			Method method = clazz.getDeclaredMethod("crtMet3");
			Object result = method.invoke(clazz.newInstance());
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------");

		try {
			Method declaredMethod = Boy.class.getDeclaredMethod("boyMet5");
			System.out.println(declaredMethod);
			declaredMethod.setAccessible(true);
			Object rs = declaredMethod.invoke(new Boy());
			System.out.println(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------");

		try {
			Method declaredMethod = clazz.getDeclaredMethod("crtMet5");
			System.out.println(declaredMethod);
			Object rs = declaredMethod.invoke(null);
			System.out.println(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
