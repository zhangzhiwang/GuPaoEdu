package com.asiainfo.p5.javaCore.reflect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

/**
 * 自定义IOC容器
 *
 * @author zhangzhiwang
 * @date Dec 9, 2019 12:09:07 PM
 */
public class MySpringIOCContainer {
	private static Map<String, Object> container = new HashMap<String, Object>();

	public static void putBean(String id, Object val) {
		container.put(id, val);
	}

	public static Object getBean(String id) {
		return container.get(id);
	}

	public static void init(String confFile) {
		try {
			// 通过dom4j解析xml
			SAXReader reader = new SAXReader();
			Document document = reader.read(confFile);
			Element rootElement = document.getRootElement();
			List<Element> elements = rootElement.elements();
			for (Element element : elements) {
				String attrId = element.attributeValue("id");
				String attrClass = element.attributeValue("class");
				String attrFactoryMethod = element.attributeValue("factory-method");
				if(StringUtils.isEmpty(attrClass)) {
					String attrFactoryBean = element.attributeValue("factory-bean");
					if(StringUtils.isEmpty(attrFactoryBean)) {
						throw new RuntimeException("实例工厂创建bean的配置有误！");
					}
					
					Object object = container.get(attrFactoryBean);
					Method attrDeclaredMethod = object.getClass().getDeclaredMethod(element.attributeValue("factory-method"));
					container.put(attrId, attrDeclaredMethod.invoke(object));
				} else if(!StringUtils.isEmpty(attrFactoryMethod)) {
					Method method = Class.forName(attrClass).getMethod(attrFactoryMethod);
					container.put(attrId, method.invoke(null));
				} else {
					container.put(attrId, Class.forName(attrClass).newInstance());
				}
			}
			System.out.println("MySpringIOCContainer初始化完成！container = " + container);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
