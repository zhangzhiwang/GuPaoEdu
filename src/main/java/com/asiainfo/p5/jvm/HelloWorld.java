package com.asiainfo.p5.jvm;

import java.io.Serializable;

import com.asiainfo.p5.io.BufferedInputStreamTest;

public class HelloWorld extends BufferedInputStreamTest implements Serializable {
	/***/
	private static final long serialVersionUID = 6206219526612889637L;
	private int i;
	private String name;
	private static byte b = 3;
	
	public void met1() {}
	
	public static int met2(int i) {
		return i;
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
