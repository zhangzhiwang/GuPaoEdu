package com.asiainfo.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 当数据流的来源是键盘输入时，使用System.in
 *
 * @author zhangzhiwang
 * @date 2021年4月14日 下午3:08:34
 */
public class SystemInTest {
	public static void main(String[] args) {
		
		try(InputStream in = System.in;) {
			int i = 0;
			while((i = in.read()) != -1) {
				System.out.print((char)i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
