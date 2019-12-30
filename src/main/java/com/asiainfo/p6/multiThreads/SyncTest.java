package com.asiainfo.p6.multiThreads;

public class SyncTest {
	// 以下三个方法是互斥的
	public static synchronized void met1() {
	}

	public static void met2() {
		synchronized (SyncTest.class) {

		}
	}

	public void met3() {
		synchronized (SyncTest.class) {

		}
	}
}
