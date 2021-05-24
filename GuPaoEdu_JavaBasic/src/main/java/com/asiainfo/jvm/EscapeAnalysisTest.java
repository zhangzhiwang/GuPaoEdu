package com.asiainfo.jvm;

/**
 * 逃逸分析测试
 *
 * @author zhangzhiwang
 * @date 2021年4月13日 下午4:44:00
 */
public class EscapeAnalysisTest {
	public static void main(String[] args) throws InterruptedException {
		// -Xmx1G -XX:+/-DoEscapeAnalysis
		for(int i = 0;i < 100000; i++) {
			m();
		}
		System.out.println("ok");
		Thread.sleep(100000);
	}
	
	public static void m() {
		User u = new User();
	}
}
