package com.asiainfo.p5.javaCore.reflect;

/**
 * 自定义config类
 *
 * @author zhangzhiwang
 * @date Dec 9, 2019 12:06:44 PM
 */
public class MySpringConfig {
	private String id;
	private String clazz;
	private String factoryBean;
	private String factoryMethod;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getFactoryBean() {
		return factoryBean;
	}

	public void setFactoryBean(String factoryBean) {
		this.factoryBean = factoryBean;
	}

	public String getFactoryMethod() {
		return factoryMethod;
	}

	public void setFactoryMethod(String factoryMethod) {
		this.factoryMethod = factoryMethod;
	}

	@Override
	public String toString() {
		return "MySpringConfig [id=" + id + ", clazz=" + clazz + ", factoryBean=" + factoryBean + ", factoryMethod=" + factoryMethod + "]";
	}

}
