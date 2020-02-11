package com.asiainfo.p5.javaCore.javaBasic;

/**
 * jdk1.7之后switch可以接受除int类型之外的String和枚举类型
 *
 * @author zhangzhiwang
 * @date 2020年2月10日 上午9:11:09
 */
public class SwitchTest {
	public static void main(String[] args) {
		int i = 10;
		String s = "a";
		UserTypeEnum u = UserTypeEnum.TYPE_1;

		switch (i) {
		case 10:
			System.out.println(10);
			break;
		case 20:
			System.out.println(20);
			break;
		default:
			System.out.println("non");
			break;
		}

		switch (s) {
		case "a":
			System.out.println("a");
			break;
		case "b":
			System.out.println("b");
			break;
		default:
			System.out.println("non");
		}

		switch (u) {
		case TYPE_1:
			System.out.println(1);
			break;
		case TYPE_2:
			System.out.println(2);
			break;
		default:
			System.out.println("non");
		}
	}
}
