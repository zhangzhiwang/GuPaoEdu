package com.asiainfo.p5.javaCore.javaBasic.refType;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Java中的软引用
 *
 * @author zhangzhiwang
 * @date 2020年2月10日 上午11:26:31
 */
public class RefType {
	private int num = 10;
	
	public static void main(String[] args) {
		RefType s = new RefType();// 强引用
		System.out.println(s);
		SoftReference<RefType> softReference = new SoftReference<RefType>(s);// 通过强引用来创建软引用
//		s = null;
		System.out.println(softReference.get());//SoftReference#get()方法返回软引用所包含的强引用
//		s = null;
		System.out.println(softReference.get());
		System.out.println(softReference.get().num);
		
		WeakReference<RefType> weakReference = new WeakReference<RefType>(s);
		System.out.println(weakReference.get());
//		System.out.println(weakReference.get().num);
		
		System.out.println("-------------");
		PhantomReference<RefType> phantomReference = new PhantomReference<RefType>(s, null);
		System.out.println(phantomReference.get());
	}
}
