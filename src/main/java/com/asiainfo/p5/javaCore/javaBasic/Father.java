/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic;

import java.io.IOException;

/**
 * 父类
 *
 * @author Administrator
 * @date 2020年1月31日 上午10:51:59
 */
public class Father {
	int num =10;
	
	public int met1(int i) {
		System.out.println("com.asiainfo.p5.javaCore.javaBasic.Father.met1(int)");
		return 0;
	}
	
	Father met3(int i) throws IOException {
		return null;
	}
	
	public int met4() {
		return 0;
	}
	
	public void met5(Father f) {}
	
	public void met6(Father f) {
		System.out.println("com.asiainfo.p5.javaCore.javaBasic.Father.met6(Father)");
	}
}
