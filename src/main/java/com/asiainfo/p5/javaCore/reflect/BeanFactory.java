package com.asiainfo.p5.javaCore.reflect;

/**
 * bean工厂
 *
 * @author zhangzhiwang
 * @date Dec 9, 2019 11:54:08 AM
 */
public class BeanFactory {
	public static SpringTest getInstanceStatic() {
		return new SpringTest();
	}
	
	public SpringTest getInstance() {
		return new SpringTest();
	}
}
