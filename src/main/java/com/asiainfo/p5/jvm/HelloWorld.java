package com.asiainfo.p5.jvm;

import java.io.Serializable;

import com.asiainfo.p5.io.BufferedInputStreamTest;

public class HelloWorld implements Serializable {
	/***/
	private static final long serialVersionUID = 6206219526612889637L;
	private int i;
	private String name;
	private static byte b = 3;// 类的静态变量保存在方法区里面
	private	static Object obj;// 类的静态变量保存在方法区里面，但是这个变量是一个对象，那么这个对象保存在堆里面，方法区保存的是这个对象的引用
	
	public void met1() {}
	
	public static int met2(int i) {
		int a = 1;
		HelloWorld h = new HelloWorld();// 局部变量保存在栈帧的局部变量表里面，但是这个局部变量是一个对象，那么这个对象存储在堆中，局部变量表保存这个对象的引用
		return i;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(Integer.MAX_VALUE);
	}
	
	/**
	 * 加载：将class文件读入到JVM内存中，并减class的元数据信息放到方法去，在堆中创建一个Class对象</br>
	   链接：</br>
			验证：验证class文件的合法性，是不是被篡改过</br>
			准备：为静态变量分配内存并赋初始值</br>
			解析：将符号引用转变为直接引用（内存地址）</br>
	   初始化：给静态变量赋予真正的值</br>
	   </br>
	   4种类加载器：</br>
	   1、根类加载器：默认加载%JAVA_HOME%/lib/rt.jar<br>
	   2、扩展类加载器：默认加载%JAVA_HOME%/lib/ext/*.jar</br>
	   3、应用类加载器：默认加载classpath下面的类</br>
	   4、自定义加载器
	 */
}
