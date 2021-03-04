package com.asiainfo.lombok;

import java.util.Date;

import lombok.ToString;


/**
 * @ToString 注解生成toString方法
 *
 * @author zhangzhiwang
 * @date 2021年3月3日 下午9:59:39
 */
//@ToString(exclude = {"age", "time"})// @ToString注解默认包含所有属性（不包含静态字段）而且@ToString只能放在类上，其中exclude属性表明哪些字段不放在toString方法里。
@ToString(of = {"GENDER", "number1"})// of属性表示toString方法里要包括哪些字段，只有在of属性指定的字段才能被包含在toString方法中。注意：该注解生成的toString方法默认包括所有字段，也包括常量，但是不包括静态字段，要想包括静态字段必须用of属性指定
public class ToStringTest {
	private static final int GENDER = 1;
	private static int number1;
	private final int NUMBER2 = 1;
	private int age;
	protected String name;
	public Date time;
}
