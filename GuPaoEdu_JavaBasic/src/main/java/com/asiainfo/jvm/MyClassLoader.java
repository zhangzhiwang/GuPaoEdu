package com.asiainfo.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.util.StringUtils;

/**
 * 自定义ClassLoader来打破双亲委派
 *
 * @author zhangzhiwang
 * @date 2021年4月8日 上午11:40:39
 */
public class MyClassLoader extends ClassLoader {
	/**
	 * ClassLoader三个主要的方法：</br>
	 * findClass方法：通过类的全限定名在文件系统或者网络查找class文件并通过字节流读入到内存中，以字节数组的形式存在</br>
	 * defineClass方法：将上一步读入的字节数组转换为Class对象</br>
	 * loadClass方法：加载Class对象到类加载器中</br>
	 */
	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		if (StringUtils.isEmpty(name)) {
			return null;
		}

		String fullName = this.getClass().getResource("/").getPath() + name.replaceAll("\\.", "/").concat(".class");
		try (InputStream in = new FileInputStream(new File(fullName));) {
			int len = in.available();
			byte[] bs = new byte[len];
			in.read(bs, 0, len);

			Class<?> clazz = defineClass(name, bs, 0, len);
			return clazz;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		synchronized (getClassLoadingLock(name)) {
			// First, check if the class has already been loaded
			Class<?> c = findLoadedClass(name);
			if (c == null) {
				long t0 = System.nanoTime();
				try {
					ClassLoader parent = getParent();
					if (parent != null && !name.startsWith("com.asiainfo")) {
						c = parent.loadClass(name);
					} else {
						c = findClass(name);
					}
				} catch (ClassNotFoundException e) {
				}

				if (c == null) {
					// If still not found, then invoke findClass in order
					// to find the class.
					long t1 = System.nanoTime();
					c = findClass(name);

					// this is the defining class loader; record the stats
					sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
					sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
					sun.misc.PerfCounter.getFindClasses().increment();
				}
			}
			if (resolve) {
				resolveClass(c);
			}
			return c;
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
//		ClassLoader classLoader = JVMTest.class.getClassLoader();
//		System.out.println(classLoader);// 默认情况下自定义的Java类都由应用类加载器来加载
//		System.out.println(MyClassLoader.class.getResource("/"));

//		System.out.println("com.asiainfo.controller".replaceAll("\\.", "/"));
		
		MyClassLoader myClassLoader = new MyClassLoader();
		Class<?> c = myClassLoader.loadClass("com.asiainfo.jvm.JVMTest");
		System.out.println(c.getClassLoader());
	}
}
