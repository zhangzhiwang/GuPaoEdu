package com.asiainfo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 自定义切面
 *
 * @author zhangzhiwang
 * @date Dec 23, 2020 1:50:08 PM
 */
@Aspect// 标明该类是一个切面类
@Component// 切面类要被Spring托管
public class MyAspect {
	/**
	 * 可以把公用的表达式抽取出来形成一个Pointcut以便复用，这个Pointcut是一个标注了@Pointcut注解的方法，该方法可以任意进行定义（访问权限、返回值类型、方法名称可以随意，但是必须是无參的），
	 * 然后在需要使用的地方通过方法名加一个小括号即可，比如@Before("pointCutTest()")
	 */
	@Pointcut("execution(* com.asiainfo.service.IUserService+.m4(..))")
	public void pointCutTest() {
//		return "asdf";
	}
	
	/**
	 * execution：定位到符合条件的某个（些）类的某个（些）方法上
	 * 语法：execution([访问权限] 返回值类型 [类型的全限定名.] 方法名(参数名) [抛出异常类型])	整体语法类似于方法的定义，其中[]表示可选
	 * 其中有三种通配符：
	 * *：匹配0-多个
	 * ..：如果用于方法参数则表示任意方法入參，如果用在包名后则表示当前包及其子包
	 * +：用在类名后表示当前类及其子类，用在接口名后表示当前接口及其实现类
	 * 
	 * 比如：
	 * execution(String com.asiainfo.service.impl.UserServiceImpl.m3(String, byte))	匹配任意访问权限的，返回值类型是String，UserServiceImpl类的m3方法，入參类型是String和byte
	 * execution(* com.asiainfo.service.impl.UserServiceImpl.m3(..))	匹配任意访问权限的，任意返回值类型，UserServiceImpl类的m3方法，入參类型任意
	 * execution(* com.asiainfo..m3(..))	匹配任意访问权限的，任意返回值类型，com.asiainfo包及其子包下的所有类型，方法名称是m3，入參类型任意
	 * execution(* com.asiainfo..*(..))		匹配任意访问权限的，任意返回值类型，com.asiainfo包及其子包下的所有类型，方法名称任意，入參类型任意
	 * execution(* com.asiainfo..*(..) throws ArrayIndexOutOfBoundsException)	匹配任意访问权限的，任意返回值类型，com.asiainfo包及其子包下的所有类型，方法名称任意，入參类型任意，声明抛出ArrayIndexOutOfBoundsException
	 * execution(* com.asiainfo.service.impl.UserServiceImpl+.m4(..))	匹配任意访问权限的，任意返回值类型，com.asiainfo.service.impl.UserServiceImpl及其子类，方法名称是m4，入參类型任意
	 */
//	@Before("execution(* com.asiainfo.service.IUserService+.m4(..))")// @Before在执行目标方法前执行
//	@Before("pointCutTest()")
	public void inject1() {
		System.out.println("MyAspect.inject1...");
	}
	
	/**
	 * within定位到某一个（些）类型，这个（些）类型的所有方法都会织入inject2逻辑
	 * 
	 * 比如：
	 * within(com.asiainfo.service.impl.UserServiceImplExt)	匹配UserServiceImplExt的所有方法
	 * within(com.asiainfo.service.impl.*)	匹配com.asiainfo.service.impl包下所有类的所有方法，注意不包含impl下面的子包
	 * within(com.asiainfo.service.impl..*)	匹配com.asiainfo.service.impl包及其子包下所有类的所有方法
	 */
	@Before("within(com.asiainfo.service.impl..*)")
	public void inject2() {
		System.out.println("MyAspect.inject2...");
	}
}
