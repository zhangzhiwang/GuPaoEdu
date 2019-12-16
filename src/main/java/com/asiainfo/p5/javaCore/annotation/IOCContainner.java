package com.asiainfo.p5.javaCore.annotation;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

/**
 * IOC容器
 *
 * @author zhangzhiwang
 * @date 2019年12月15日 下午11:26:49
 */
public class IOCContainner {
	private static Map<String, Object> containner = new HashMap<String, Object>();
	private static Set<String> allFileNames = new HashSet<String>();

	public static void putBean(String beanId, Object bean) {
		containner.put(beanId, bean);
	}

	public static Object getBean(String beanId) {
		return containner.get(beanId);
	}

	/**
	 * 通过扫描配置文件中的标签context:component-scan的属性base-package来实例化bean
	 * 
	 * @author zhangzhiwang
	 * @date 2019年12月15日 下午11:47:32
	 */
	public static void init(String confFile) {
		try {
			// 通过dom4j解析xml
			SAXReader reader = new SAXReader();
			Document document = reader.read(confFile);
			Element rootElement = document.getRootElement();
			List<Element> elements = rootElement.elements();
			String basePackage = "";
			for (Element element : elements) {
				if(!element.getName().equals("component-scan")) {
					continue;
				}
				basePackage = element.attributeValue("base-package");
			}
			
			basePackage = basePackage.replace(".", File.separator);
			addAllFiles(basePackage);
			
			for(String fullName : allFileNames) {
				Class<?> clazz = Class.forName(fullName = fullName.replace(File.separator, "."));
				if(clazz.isAnnotationPresent(MyAnnotation.class)) {
					putBean(fullName, clazz.isInterface() ? null : clazz.newInstance());// 如果是接口，实例尚且设置为null
				} else {
					Method[] declaredMethods = clazz.getDeclaredMethods();
					if(declaredMethods != null && declaredMethods.length > 0) {
						for(Method method : declaredMethods) {
							if(method.isAnnotationPresent(MyBean.class)) {
								String annoValue = method.getAnnotation(MyBean.class).value();
								if(Modifier.isStatic(method.getModifiers())) {
									putBean(annoValue, method.invoke(null));
								} else {
									putBean(annoValue, method.invoke(clazz.newInstance()));
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void addAllFiles(String dir) {
		File file = new File("target/classes/" + dir);
		File[] listFiles = file.listFiles();
		for(File f : listFiles) {
			if(f.isDirectory()) {
				addAllFiles(dir + File.separator + f.getName());
			}
			
			if(!f.getName().endsWith(".class")) {
				continue;
			}
			allFileNames.add(dir + File.separator + f.getName().replace(".class", ""));
		}
	}
}
