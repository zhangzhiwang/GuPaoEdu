package com.asiainfo.p5.javaCore.multiThreads;

public class SyncTest {
	private static Integer i1 = 0;
	
	public static void main(String[] args) {
		Integer i2 = i1;
		System.out.println(i2 == i1);
		i1 = i1 + 1;
		System.out.println(i2 == i1);
	}
}
