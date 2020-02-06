package com.asiainfo.p6.jvm;

public class GcMethod {
	public static void main(String[] args) {
		System.gc();// 当调用System.gc()的时候并不会马上进行gc，具体什么时候进行gc取决于JVM，此方法只是给JVM提出一个要gc的建议。
	}
}
