package com.asiainfo.p5.javaCore.annotation;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

/**
 * IOC容器测试
 *
 * @author zhangzhiwang
 * @date 2019年12月15日 下午11:26:49
 */
public class IOCContainnerTest {
	public static void main(String[] args) {
		IOCContainner.init("src/main/resources/applicationContext.xml");
		Object bean1 = IOCContainner.getBean("com.asiainfo.p5.javaCore.annotation.MyClass");
		Object bean2 = IOCContainner.getBean("getA");
		Object bean3 = IOCContainner.getBean("getB");
		System.out.println(bean1);
		System.out.println(bean2);
		System.out.println(bean3);
	}
}
