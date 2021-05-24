package com.asiainfo.jvm;

/**
 * java.lang.StackOverflowError
 * 注意：java.lang.StackOverflowError和java.lang.OutOfMemoryError是平级的，就像Map接口和Collection接口一样，Java虚拟机栈溢出抛的也是内存溢出错误但是不是OutOfMemoryError
 * 
 * @author zhangzhiwang
 * @date 2021年4月8日 下午2:45:10
 */
public class StackOverflowErrorTest {
	private static int count = 0;
	
	public static void main(String[] args) {
		// -Xss160k
        met1();
    }
	
	public static void met1() {
		System.out.println(count++);
		met1();
	}
}
