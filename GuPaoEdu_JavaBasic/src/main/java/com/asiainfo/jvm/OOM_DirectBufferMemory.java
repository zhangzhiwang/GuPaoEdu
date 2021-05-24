package com.asiainfo.jvm;

import java.nio.ByteBuffer;
import sun.nio.ch.DirectBuffer;

/**
 * 堆外内存溢出也会抛出OOM：java.lang.OutOfMemoryError: Direct buffer memory
 * 介绍堆外内存比较好的文章：https://blog.csdn.net/cenjia7278/article/details/100956140    https://blog.csdn.net/weixin_39602891/article/details/114198185
 * 堆外内存的分配和回收：
 * 由于外界不能使用Unsafe类来操作堆外内存，所以可以使用nio包的DirectByteBuffer。DirectByteBuffer创建时会在堆里创建DirectByteBuffer对象并且持有堆外内存的引用，
 * 同时还在堆中创建Cleaner对象，DirectByteBuffer对象持有Cleaner对象的引用，这个引用是强引用。当外界没有对象持有DirectByteBuffer引用的时候，也就是gc root到它不可达，
 * 垃圾收集器会对其进行回收，回收之后Cleaner对象就没有强引用来引用它了，这样也就成了垃圾对象，在gc时会被回收。这里有一点要注意：Cleaner类里面有一个静态变量first，用于存储由Cleaner对象组成的双向链表，
 * 由于是类的静态变量所以first变量会在方法区里，指向堆中的Cleaner对象。在DirectByteBuffer对象被回收后还有一个first来引用Cleaner对象，下面是重点：Cleaner类是虚引用PhantomReference的子类，如果除了虚引用之外没有强引用来引用
 * Cleaner对象的时候，Cleaner对象就会被回收掉。后面具体的过程可以参考文章：https://blog.csdn.net/cenjia7278/article/details/100956140，总之回收cleaner对象就会调用clean方法，clean方法会调用unsafe的释放内存的方法，从而释放堆外内存。
 *
 *
 * @author zhangzhiwang
 * @date 2021年4月13日 上午9:51:57
 */
@SuppressWarnings("restriction")
public class OOM_DirectBufferMemory {
	public static void main(String[] args) throws InterruptedException {
		// -XX:MaxDirectMemorySize=100m，注意如果指定了-Xmx而没有指定-XX:MaxDirectMemorySize，那么默认-XX:MaxDirectMemorySize=-Xmx
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024 * 128);// 128M
		
		Thread.sleep(100000);
		
		// 回收直接内存
		DirectBuffer directBuffer = (DirectBuffer) byteBuffer;
		directBuffer.cleaner().clean();
	}
}
