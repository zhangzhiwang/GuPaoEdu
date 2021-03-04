package com.asiainfo.lombok;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @NonNull和有关构造器的注解
 *
 * @author zhangzhiwang
 * @date 2021年3月3日 下午10:47:49
 */
//@NoArgsConstructor// 添加无参构造器
@AllArgsConstructor// 添加所有字段的构造器，但是不包括static字段，final字段分情况：如果final字段在声明的时候赋值了那么生成的构造方法就没有该字段，反之有
@RequiredArgsConstructor// 添加指定字段的构造器，“指定字段”就是指被@NonNull注解修饰的字段，但是不包含static字段，即使static字段加上@NonNull也不起作用，final字段也分情况，情况和上面一样
public class NonNullAndConstructor {
	@NonNull
	private static final String GENDER = "1";
	@NonNull
	private static String number1;
	private final int NUMBER2 = 1;
	private int age;
	@NonNull
	protected String name;
	@NonNull
	public Date time;

	/**
	 * @NonNull 注解表示不能为null，如果为null则报空指针
	 * 
	 * @param s
	 * @author zhangzhiwang
	 * @date 2021年3月3日 下午10:49:17
	 */
	public void test(@NonNull String s) {
		// lombok会自动重写java文件，加上下面这个if判断，通过class反编译可以看出来
//		if (s == null) {
//			throw new NullPointerException("s is marked non-null but is null");
//		}
	}

//	public static void main(String[] args) {
//		new NonNullAndConstructor().test("");
//	}
}
