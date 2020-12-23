package com.asiainfo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 自定义切面
 *
 * @author zhangzhiwang
 * @date Dec 23, 2020 1:50:08 PM
 */
//@Aspect// 标明该类是一个切面类
//@Component// 切面类要被Spring托管
public class MyAspect {
	/**
	 * execution：定位到符合条件的某个（些）类的某个（些）方法上
	 * 语法：execution([访问权限] 返回值类型 [类型的全限定名.] 方法名(参数名) [抛出异常类型])	整体语法类似于方法的定义，其中[]表示可选
	 * 其中有三种通配符：
	 * *：匹配0-多个
	 * ..：如果用于方法参数则表示任意方法入參，如果用在包名后则表示当前包及其子包
	 * +：用在类名后表示当前包及其子包，用在接口名后表示当前接口及其实现类
	 * 
	 * 比如：
	 * 
	 */
	@Before("execution(void com.asiainfo.service.impl.UserServiceImpl.m1(..))")// @Before在执行目标方法前执行
	public void inject1() {}
}
