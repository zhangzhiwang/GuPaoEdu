package com.asiainfo.servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.asiainfo.User1;
import com.asiainfo.annotation.ZzwAutowired;
import com.asiainfo.annotation.ZzwComponent;
import com.asiainfo.entity.User2;

public class ZzwDispatcherServlet extends HttpServlet {
	private String zzwConfigFileLocation;
	// 将xml配置文件的内容保存进Properties中
	private Properties properties = new Properties();
	// 保存扫描包路径下所有标注了特定注解的类全限定名
	private List<String> scanClasses = new ArrayList<>();
	// ioc容器
	private Map<String, Object> ioc = new HashMap<>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 1、加载配置文件
		loadConfigFile(config);
		// 2、扫描相关的类
		scanClasses(properties.getProperty("basePackage"));
		// 3、初始化上一步扫描到的类的实例并放入到ioc容器中
		initIocContainer();
		// 4、依赖注入
		di();
		// 5、初始化HandlerMapping
	}

	private void di() {
		// 由于是手写简易版的spring所以只支持@ZzwAutowired和@javax.annotation.Resource注解
		if(ioc.size() == 0) {
			return;
		}
		
		for(String beanName : ioc.keySet()) {
			Object object = ioc.get(beanName);
			Field[] declaredFields = object.getClass().getDeclaredFields();
			for(Field field : declaredFields) {
				if(field.isAnnotationPresent(ZzwAutowired.class)) {// 按类型注入
					Object o = ioc.get(field.getType().getClass());// field.getType()获取的是改field所属的类型，注意不是getClass()方法，getClass()获取的是field本身的Class对象——java.lang.reflect.Field
//					if(o) {}
				} else if(field.isAnnotationPresent(Resource.class)) {// 按类型或者按名称注入
					
 				} else {
 					continue;
 				}
			}
		}
	}

	private void initIocContainer() {
		if(scanClasses.size() == 0) {
			return;
		}
		
		for(String className : scanClasses) {
			try {
				Class<?> clazz = Class.forName(className);
				// 只实例化标注了@ZzwComponent的类
				if(!clazz.isAnnotationPresent(ZzwComponent.class)) {// isAnnotationPresent方法用来检测某个类的定义上是否加了指定注解
					continue;
				}
				
				ZzwComponent zzwComponent = clazz.getAnnotation(ZzwComponent.class);
				Object newInstance = clazz.newInstance();
				String zzwComponentValue = zzwComponent.value();// 取出注解value的值
				if(StringUtils.isNoneBlank(zzwComponentValue)) {
					if(ioc.get(zzwComponentValue) != null) {// 由于是自己写的简易版的spring，所以如果bean名称相同的话（无论是自定义名称还是类本身的全限定名还是实现接口的全限定名）要抛异常以免key相同覆盖
						throw new RuntimeException("已存在名称为" + zzwComponentValue + "的bean！");
					}
					ioc.put(zzwComponentValue, newInstance);// key放自定义名称
				}
				
				if(ioc.get(className) != null) {
					throw new RuntimeException("已存在名称为" + zzwComponentValue + "的bean！");
				}
				ioc.put(className, newInstance);// 即使上面放了自定义名称的bean，也要放一个全路径名为key的bean
				
				// 如果该类还实现接口的话，那么还要以实现的每个接口的全限定名为key放入到ioc中。
				// 也就是说如果一个类加了@ZzwComponent注解并自定义了名称，同事还实现了多个接口，那么在ioc中会存放多个该类的同一实例，只不过ioc中的key不同
				Class<?>[] interfaces = clazz.getInterfaces();
				for(Class<?> interfaceClass : interfaces) {
					String interfaceClassName = interfaceClass.getName();
					if(ioc.get(interfaceClassName) != null) {
						throw new RuntimeException("已存在名称为" + zzwComponentValue + "的bean！");
					}
					ioc.put(interfaceClassName, newInstance);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void scanClasses(String packages) {
		// 将包结构中的“.”换成“/”
		URL url = this.getClass().getClassLoader().getResource("/" + packages.replaceAll(".", "/"));
		File file = new File(url.getFile());
		for(File f : file.listFiles()) {
			String fileName = f.getName();
			if(f.isDirectory()) {
				scanClasses(packages + "." + fileName);
			} else if(fileName.endsWith("class")) {
				String className = packages + "." + fileName.substring(0, fileName.length() - 6);// 去掉.class后缀
				scanClasses.add(className);
			}
		}
	}

	/**
	 * 加载配置文件
	 *
	 * @author zhangzhiwang
	 * @date 2021年3月24日 下午8:57:45
	 */
	private void loadConfigFile(ServletConfig config) {
		String fileLocation = config.getInitParameter("zzwConfigFileLocation");
		if (StringUtils.isBlank(fileLocation)) {
			throw new RuntimeException("没有定义配置文件的位置!");
		}
		
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File(fileLocation));
			Element rootElement = document.getRootElement();
			Element scan = rootElement.element("zzwComponentScan");
			Attribute attribute = scan.attribute("basePackage");
			String basePackage = attribute.getText();
			properties.put("basePackage", basePackage);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	public String getZzwConfigFileLocation() {
		return zzwConfigFileLocation;
	}

	public void setZzwConfigFileLocation(String zzwConfigFileLocation) {
		this.zzwConfigFileLocation = zzwConfigFileLocation;
	}

	public static void main(String[] args) throws Exception {
//		SAXReader reader = new SAXReader();
//		Document document = reader.read(new File("/Applications/Eclipse.app/Contents/Eclipse/workspace_study/GuPaoEdu/GuPaoEdu_WriteMiniSpring/src/main/resources/ZzwConfig.xml"));
//		Element rootElement = document.getRootElement();
//		Element scan = rootElement.element("zzwComponentScan");
//		Attribute attribute = scan.attribute("basePackage");
//		String text = attribute.getText();
//		System.out.println(text);
//		String s = "abc.class";
//		System.out.println(s.substring(0, s.length() - 6));
//		System.out.println(User1.class.isAnnotationPresent(ZzwComponent.class));
		Class c = User1.class;
		Field[] declaredFields = c.getDeclaredFields();
		for(Field f : declaredFields) {
			System.out.println(f.getType().getName());
		}
	}
}
