package com.asiainfo.p5.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * 同一个类用不同的类加载器加载会出现什么情况
 *
 * @author zhangzhiwang
 * @date Jan 17, 2020 2:30:58 PM
 */
public class ClassLoaderTest2 {
	public static void main(String[] args) throws ClassNotFoundException {
//		System.out.println(String.class.getClassLoader());
		System.out.println(ClassLoaderTest2.class.getClassLoader());// 扩展类加载器默认加载%JAVA_HOME%/jre/lib/ext下面的class文件，也可以通过参数指定扩展类加载器加载的路径，但是注意扩展类加载器只加载jar包，不加载单个的class文件，所以要测试话需要把class文件打进jar包中。
	}
}
