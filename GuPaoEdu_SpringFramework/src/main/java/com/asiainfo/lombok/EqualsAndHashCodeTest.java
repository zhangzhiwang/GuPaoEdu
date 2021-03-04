package com.asiainfo.lombok;

import java.util.Date;

import lombok.EqualsAndHashCode;

/**
 * @EqualsAndHashCode 注解生成equals和hashCode方法
 *
 * @author zhangzhiwang
 * @date 2021年3月3日 下午10:13:42
 */
/**
 * @EqualsAndHashCode 注解生成的euqals和hashCode方法默认将所用非静态非常量的字段参与运算，即包括除static和final以外的字段。
 * of属性用于指定哪些字段可以参与运算，但是要注意：默认情况下static变量是不参与运算的，如果of指定了static变量，则该变量可以参与运算，但是final变量指定了也不行，final变量就是不能参与比较运算
 */
//@EqualsAndHashCode(of = {"GENDER", "number1", "NUMBER2"})
@EqualsAndHashCode(exclude = {"name"})// exclude属性指定哪些字段不参与比较运算
public class EqualsAndHashCodeTest {
	private static final int GENDER = 1;
	private static int number1;
	private final int NUMBER2 = 1;
	private int age;
	protected String name;
	public Date time;
}
