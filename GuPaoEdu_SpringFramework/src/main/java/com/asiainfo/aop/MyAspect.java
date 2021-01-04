package com.asiainfo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
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
	 * 
	 * @Before 前置通知
	 */
//	@Before("execution(* com.asiainfo.service.IUserService+.m4(..))")
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
//	@Before("within(com.asiainfo.service.impl..*)")
	public void inject2() {
		System.out.println("MyAspect.inject2...");
	}
	
	/**
	 * this匹配代理对象
	 */
//	@Before("this(com.asiainfo.service.impl.UserServiceImpl)")// aop默认的是jdk动态代理，如果要强制使用cglib动态代理那么需要在@EnableAspectJAutoProxy加参数proxyTargetClass并设置值为true
	public void inject3() {
		System.out.println("MyAspect.inject3...");
	}
	
	/**
	 * target匹配目标对象
	 */
//	@Before("target(com.asiainfo.service.impl.UserServiceImpl)")
	public void inject4() {
		System.out.println("MyAspect.inject4...");
	}
	
	/**
	 * args匹配方法的入參类型，注意单独使用args会匹配扫描路径下的所有包的所有类的所有符合指定参数类型的方法
	 * 可以组合使用注解并用&&连接，这样可以缩小范围
	 */
//	@Before("target(com.asiainfo.service.impl.UserServiceImpl) && args(String,byte)")
	public void inject5() {
		System.out.println("MyAspect.inject5...");
	}
	
	/**
	 * @args 匹配方法的入參的类型被指定注解修饰，注意是方法入參所属的类型不是方法的入參之前加注解，而且单独使用该注解会匹配扫描路径下的所有包的所有类的所有符合条件的方法
	 */
//	@Before("@args(com.asiainfo.aop.MyAnnotation1,com.asiainfo.aop.MyAnnotation3,org.springframework.stereotype.Service)")
	@Before("target(com.asiainfo.service.impl.UserServiceImpl) && @args(com.asiainfo.aop.MyAnnotation1,com.asiainfo.aop.MyAnnotation3,org.springframework.stereotype.Service)")
	public void inject6() {
		System.out.println("MyAspect.inject6...");
	}
	
	/**
	 * @within 匹配的目标类要被指定注解修饰
	 */
//	@Before("@within(com.asiainfo.aop.MyAnnotation1)")
//	@Before("target(com.asiainfo.service.impl.UserServiceImpl) && @within(com.asiainfo.aop.MyAnnotation1)")
	public void inject7() {
		System.out.println("MyAspect.inject7...");
	}
	
	/**
	 * @annotation 匹配的目标方法要被指定注解修饰
	 */
//	@Before("@annotation(com.asiainfo.aop.MyAnnotation2)")
//	@Before("target(com.asiainfo.service.impl.UserServiceImpl) && @annotation(com.asiainfo.aop.MyAnnotation2)")
	public void inject8() {
		System.out.println("MyAspect.inject8...");
	}
	
	@Before("execution(* com.asiainfo.service.impl.UserServiceImpl.m3(..))")
	public void before() {
		System.out.println("前置通知");
	}
	
	/**
	 * @AfterReturning 后置通知
	 * 
	 * @param result
	 * @author zhangzhiwang
	 * @date Jan 4, 2021 10:26:47 PM
	 */
	@AfterReturning(value = "execution(* com.asiainfo.service.impl.UserServiceImpl.m3(..))", returning = "result")// returning参数表示接收目标方法的返回值，该属性的值要和标注@AfterReturning注解的方法定义的形参名一致，否则报异常
	public void afterReturning(Object result) {// 形参名要和上面returning属性的值一致
		System.out.println("后置通知：" + result);
	}
	
	/**
	 * @Around 环绕通知
	 * 如果同时有潜质通知和后置通知和环绕通知，那么执行顺序是：环绕通知->前置通知->目标方法->后置通知->环绕通知
	 * 
	 * @author zhangzhiwang
	 * @throws Throwable 
	 * @date Jan 4, 2021 10:27:00 PM
	 */
	@Around(value = "execution(* com.asiainfo.service.impl.UserServiceImpl.m3(..))")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("环绕通知，目标方法执行之前...");
		Object[] args = proceedingJoinPoint.getArgs();
		System.out.print("参数：");
		for(Object arg : args) {
			System.out.print(arg + "\t");
		}
		System.out.println();
		
		Object result = proceedingJoinPoint.proceed();// 执行目标方法，result为目标方法的返回值
		
		System.out.println("环绕通知，目标方法执行之后，返回结果：" + result);
	}
	
	/**
	 * @AfterThrowing 异常通知
	 * 
	 * @param e
	 * @author zhangzhiwang
	 * @date Jan 4, 2021 10:35:36 PM
	 */
	@AfterThrowing(value = "execution(* com.asiainfo.service.impl.UserServiceImpl.m3(..))", throwing = "e")// 注意throwing属性的值要和afterThrowing方法的形参名称一致
	public void afterThrowing(Exception e) {
		System.out.println("异常通知：" + e);
	}
	
	/**
	 * @After 最终通知——无论怎样都会执行，类似finally代码块
	 * 
	 * @author zhangzhiwang
	 * @date Jan 4, 2021 10:43:12 PM
	 */
	@After(value = "execution(* com.asiainfo.service.impl.UserServiceImpl.m3(..))")
	public void after() {
		System.out.println("最终通知");
	}
}
