/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic.string;

/**
 * 将字符串反转的方式
 *
 * @author Administrator
 * @date 2020年2月2日 下午8:09:17
 */
public class ReverseString {
	/**
	 * 使用StringBuilder（或者StringBuffer）的reverse方法
	 * 
	 * @param str
	 * @return
	 * @author Administrator
	 * @date 2020年2月2日 下午8:10:18
	 */
	public static String reverseString(String str) {
		// 参数校验省略
		return new StringBuilder(str).reverse().toString();
	}
	
	/**
	 * 使用递归
	 * 
	 * @return
	 * @author Administrator
	 * @date 2020年2月2日 下午8:15:55
	 */
	public static String reverseStringbyResurse(String str) {
		if(str == null || str.length() <= 1) {
			return str;
		}
		
		return reverseStringbyResurse(str.substring(1)) + str.charAt(0);
	}
	
    /**
     * 自己实现
     * @param str
     * @return
     */
    public static String reverseStr(String str) {
        if (str != null && str.length() > 0) {
            int len = str.length();
            char[] chars = new char[len];
            for (int i = len - 1; i >= 0; i--) {
                chars[len - 1 - i] = str.charAt(i);
            }
            return new String(chars);
        }
        return str;
    }
	
	public static void main(String[] args) {
		String s = "abc";
		String result1 = reverseString(s);
		System.out.println(result1);
		
		String result2 = reverseStringbyResurse(s);
		System.out.println(result2);
		
		String result3 = reverseStr(s);
		System.out.println(result3);
	}
}
