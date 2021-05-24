package com.asiainfo.jvm;

import java.nio.ByteBuffer;

import sun.misc.Unsafe;

/**
 * 堆外内存，也叫直接内存
 * 使用堆外内存的方式有两种：
 * 1、使用Unsafe类操作堆外内存
 * 2、使用nio包下的ByteBuffer来操作堆外内存
 *
 * @author zhangzhiwang
 * @date 2021年4月13日 上午10:13:16
 */
@SuppressWarnings("restriction")
public class DirectMemory {
	public static void main(String[] args) {
		// 1、使用Unsafe类，但是运行会抛异常 java.lang.SecurityException: Unsafe，因为Unsafe是不允许外界使用的
//		Unsafe unsafe = Unsafe.getUnsafe();
//		unsafe.allocateMemory(1024);// 分配内存
//		unsafe.reallocateMemory(1024, 1024);// 重新分配内存
//		unsafe.freeMemory(1024);// 释放堆外内存
		
		// 2、使用ByteBuffer
		ByteBuffer buffer = ByteBuffer.allocateDirect(10 * 1024 * 1024);
	}
}
