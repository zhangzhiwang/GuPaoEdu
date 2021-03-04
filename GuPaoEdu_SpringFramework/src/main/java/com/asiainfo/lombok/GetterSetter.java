package com.asiainfo.lombok;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @Getter和@Setter注解
 * lombok作用的时机是生成class文件之前重写的java文件，并不是修改的class文件
 *
 * @author zhangzhiwang
 * @date 2021年3月3日 下午9:00:46
 */
@Getter(lombok.AccessLevel.PROTECTED)// 如果给该类的所有属性都加入setter和getter方法，为了简化配置可以将这两个注解放在类上，这样所有属性都会生成这两个方法
@Setter
public class GetterSetter {
	private static final int GENDER = 1;
	/**
	 * 以@Getter注解举例，如果该注解写在了类上，那么静态属性不会生成getter方法，换句话说就是@Getter注解写在类上对该类的静态属性不起作用，
	 * 如果想给静态属性添加getter方法就必须在该属性上写@Getter注解，但是生成的getter方法也是静态的，@Setter注解同理。
	 * */
//	@Getter
//	@Setter
	private static int number1;
	/**
	 * 常量（final属性）是不能改变其值的，所以@Setter方法写在类上对final变量不起作用，即不会生成对final变量的setter方法，如果强行写在常量上，编译不通过，@Getter注解不受影响。
	 * */
	private final int NUMBER2 = 1;
	
//	@Getter(lombok.AccessLevel.PRIVATE)// 生成getter方法，value属性表示生成的getter方法的访问控制权限，通过看@Getter注解的源码可知生成的getter方法默认是public的
//	@Setter(lombok.AccessLevel.PROTECTED)
	private int age;
//	@Getter(lombok.AccessLevel.PACKAGE)
	protected String name;
	@Setter(lombok.AccessLevel.NONE)// 如果在类上设置了@Setter注解，但是里面的某些属性不希望生成setter方法，可以在这些属性上面加上@Setter注解，value属性设置为lombok.AccessLevel.NONE，该属性就不会生成setter方法了，getter同理
	@Getter(lombok.AccessLevel.PUBLIC)// 如果成员变量和类上有相同的注解，那么成员变量上注解的属性会覆盖类注解的属性，即如果发生冲突以成员变量的注解为主
	public Date time;
}
