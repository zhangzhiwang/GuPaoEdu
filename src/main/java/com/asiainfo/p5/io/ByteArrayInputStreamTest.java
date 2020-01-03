package com.asiainfo.p5.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * 基于内存的io操作
 *
 * @author zhangzhiwang
 * @date Jan 3, 2020 8:02:28 PM
 */
public class ByteArrayInputStreamTest {
	public static void main(String[] args) {
		// 内存中有个数据s，用基于内存输入输出流的ByteArrayInputStream和ByteArrayOutputStream来转成大写
		String s = "May be read from tHe stream. An internal";
		
		ByteArrayInputStream byteArrayInputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		
		try {
			byteArrayInputStream = new ByteArrayInputStream(s.getBytes());
			byteArrayOutputStream = new ByteArrayOutputStream();
			
			int i = 0;
			while((i = byteArrayInputStream.read()) != -1) {
				byteArrayOutputStream.write(Character.toUpperCase(i));
			}
			
			System.out.println(byteArrayOutputStream.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
