package com.asiainfo.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import com.asiainfo.annotation.ZzwRequestMapping;
import com.asiainfo.controller.TestController;
import com.asiainfo.entity.User2;

public class ZzwDispatcherServlet extends HttpServlet {
	private String zzwConfigFileLocation;
	// 将xml配置文件的内容保存进Properties中
	private Properties properties = new Properties();
	// 保存扫描包路径下所有标注了特定注解的类全限定名
	private List<String> scanClasses = new ArrayList<>();
	// ioc容器
	private Map<String, Object> ioc = new HashMap<>();
	// 存放url和方法的映射
	private Map<String, Method> urlMap = new HashMap<>();

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
		initHandlerMapping();
	}

	private void initHandlerMapping() {
		try {
			if (ioc.size() == 0) {
				return;
			}

			for (String beanName : ioc.keySet()) {
				Object object = ioc.get(beanName);
				// 类上面的路径
				String classUrl = "";
				if (object.getClass().isAnnotationPresent(ZzwRequestMapping.class)) {
					ZzwRequestMapping zzwRequestMapping = object.getClass().getAnnotation(ZzwRequestMapping.class);
					classUrl = zzwRequestMapping.value();
				}

				// 方法上面的路径
				Method[] declaredMethods = object.getClass().getDeclaredMethods();
				for (Method method : declaredMethods) {
					if (!method.isAnnotationPresent(ZzwRequestMapping.class)) {
						continue;
					}
					// 如果方法上标注了@ZzwRequestMapping注解
					ZzwRequestMapping zzwRequestMapping = method.getAnnotation(ZzwRequestMapping.class);
					String methodUrl = zzwRequestMapping.value();
					String wholeUrl = ("/" + classUrl + "/" + methodUrl).replaceAll("/+", "/");// 将类映射路径和方法映射路径拼接起来，然后将有两个斜杠“//”的地方替换成一个斜杠“/”
					Method m = urlMap.get(wholeUrl);
					if (m != null) {
						throw new RuntimeException("已存在相同的映射路径" + wholeUrl);
					}

					urlMap.put(wholeUrl, method);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void di() {
		try {
			// 由于是手写简易版的spring所以只支持@ZzwAutowired和@javax.annotation.Resource注解
			if (ioc.size() == 0) {
				return;
			}

			for (String beanName : ioc.keySet()) {
				Object object = ioc.get(beanName);
				Field[] declaredFields = object.getClass().getDeclaredFields();
				for (Field field : declaredFields) {
					field.setAccessible(true);
					if (field.isAnnotationPresent(ZzwAutowired.class)) {// 按类型注入
						String fieldTypeName = field.getType().getName();// field.getType()获取的是改field所属的类型，注意不是getClass()方法，getClass()获取的是field本身的Class对象——java.lang.reflect.Field
						Object fieldValue = ioc.get(fieldTypeName);
						if (fieldValue == null) {
							throw new RuntimeException("不存在" + fieldTypeName + "类型的bean");
						}

						field.set(object, fieldValue);
					} else if (field.isAnnotationPresent(Resource.class)) {// 按类型或者按名称注入
						Resource resourceAnno = field.getAnnotation(Resource.class);
						Object o = null;
						String bn = "";
						/**
						 * 由于实现的是简易版的Spring，所以这里简化处理： 如果@Resource注解设置了name属性的值那么会按照名称注入，如果设置了type的值则按照类型注入， 如果没有设置任何属性的值则将该变量的名称作为bean的名称来注入，如果即设置了name也设置了type则按名称来注入
						 */
						if (StringUtils.isNotBlank(resourceAnno.name())) {
							bn = resourceAnno.name();
							o = ioc.get(bn);
							field.set(object, o);
						} else if (!resourceAnno.type().equals(Object.class)) {// 看@Resource源码发现type属性默认值不是空而是Object.class
							bn = resourceAnno.type().getName();
							o = ioc.get(bn);
							field.set(object, o);
						} else {
							bn = field.getName();
							o = ioc.get(bn);
						}
						
						if (o == null) {
							throw new RuntimeException("没有这样的bean：" + bn);
						}
						field.set(object, o);
					} else {
						continue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initIocContainer() {
		if (scanClasses.size() == 0) {
			return;
		}

		for (String className : scanClasses) {
			try {
				Class<?> clazz = Class.forName(className);
				// 只实例化标注了@ZzwComponent的类
				if (!clazz.isAnnotationPresent(ZzwComponent.class)) {// isAnnotationPresent方法用来检测某个类的定义上是否加了指定注解
					continue;
				}

				ZzwComponent zzwComponent = clazz.getAnnotation(ZzwComponent.class);
				Object newInstance = clazz.newInstance();
				String zzwComponentValue = zzwComponent.value();// 取出注解value的值
				if (StringUtils.isNotBlank(zzwComponentValue)) {
					if (ioc.get(zzwComponentValue) != null) {// 由于是自己写的简易版的spring，所以如果bean名称相同的话（无论是自定义名称还是类本身的全限定名还是实现接口的全限定名）要抛异常以免key相同覆盖
						throw new RuntimeException("已存在名称为" + zzwComponentValue + "的bean！");
					}
					ioc.put(zzwComponentValue, newInstance);// key放自定义名称
				}

				if (ioc.get(className) != null) {
					throw new RuntimeException("已存在名称为" + zzwComponentValue + "的bean！");
				}
				ioc.put(className, newInstance);// 即使上面放了自定义名称的bean，也要放一个全路径名为key的bean

				// 如果该类还实现接口的话，那么还要以实现的每个接口的全限定名为key放入到ioc中。
				// 也就是说如果一个类加了@ZzwComponent注解并自定义了名称，同事还实现了多个接口，那么在ioc中会存放多个该类的同一实例，只不过ioc中的key不同
				Class<?>[] interfaces = clazz.getInterfaces();
				for (Class<?> interfaceClass : interfaces) {
					String interfaceClassName = interfaceClass.getName();
					if (ioc.get(interfaceClassName) != null) {
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
		String newPackage = packages.replaceAll("\\.", "/").replaceAll("/+", "/");
		URL url = this.getClass().getClassLoader().getResource(newPackage);
		File file = new File(url.getFile());
		for (File f : file.listFiles()) {
			String fileName = f.getName();
			if (f.isDirectory()) {
				scanClasses(newPackage + "/" + fileName);
			} else if (fileName.endsWith("class")) {
				String className = packages + "." + fileName.substring(0, fileName.length() - 6);// 去掉.class后缀
				scanClasses.add(className.replaceAll("/", "."));
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
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileLocation);
			Document document = reader.read(inputStream);
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
		String uri = req.getRequestURI();// /GuPaoEdu_WriteMiniSpring/test/test1
		String contextPath = req.getContextPath();// /GuPaoEdu_WriteMiniSpring
		String path = uri.replace(contextPath, "");
		
		Method method = urlMap.get(path);
		if(method == null) {
			resp.getWriter().write("啊哦，404了！");
			return;
		}
		
		Class<?> clazz = method.getDeclaringClass();// 获取method所属的类
		Object object = ioc.get(clazz.getName());
		
		// 从req中获取参数
		Map<String, String[]> parameterMap = req.getParameterMap();
		try {
			Object result = method.invoke(object, new Object[] {parameterMap.get("userName")[0]});// 为了方便测试，这里将入參名称写死，前端穿入参数的名称必须为userName1
			if(result != null) {
				resp.getWriter().write(result.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("啊哦，500了！");
			return;
		}
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
//		Class c = User1.class;
//		Field[] declaredFields = c.getDeclaredFields();
//		for (Field f : declaredFields) {
//			System.out.println(f.getName());
//		}
//		String s = ".com.asiainfo";
//		System.out.println(s.startsWith("."));
//		Class<?> c = Class.forName("com.asiainfo.controller.TestController");
//		System.out.println(c);
//		System.out.println(TestController.class.isAnnotationPresent(ZzwRequestMapping.class));
//		ZzwRequestMapping annotation = c.getAnnotation(ZzwRequestMapping.class);
//		System.out.println(annotation);
	}
}
