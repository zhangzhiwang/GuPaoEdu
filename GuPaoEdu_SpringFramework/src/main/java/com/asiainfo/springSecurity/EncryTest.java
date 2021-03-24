package com.asiainfo.springSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * spring security加密测试
 *
 * @author zhangzhiwang
 * @date 2021年3月22日 下午8:46:06
 */
public class EncryTest {
	public static void main(String[] args) {
		// spring security使用BCryptPasswordEncoder加密，它每次加密使用一个随机的salt然后保存在内存中，所以每次生成的密文不一样
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("123"));
		System.out.println(bCryptPasswordEncoder.encode("123"));
		System.out.println(bCryptPasswordEncoder.encode("123"));
	}
}
