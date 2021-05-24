package com.asiainfo.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * 如果数据流的来源介质是内存，那么要使用ByteArrayInputStream、ByteArrayOutputStream
 *
 * @author zhangzhiwang
 * @date 2021年4月14日 上午11:45:04
 */
public class ByteArrayInputStreamTest {
	public static void main(String[] args) {
//		String str = "abc\n"
//				+ "def";// 这个数据来源于内存
//		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
////		int i = 0;
////		while((i = in.read()) != -1) {
////			System.out.print((char)i);
////		}
//		
//		int available = in.available();// 再次强调：available方法是剩余可读到字节总数，每read()一次，available()就减少一个
//		for(int i = 0; i < available; i++) {
//			System.out.print((char)in.read());
//		}

		// 需求：从内存读入字符串，然后转换成大写再输出到内从中
		String str = "abcd\n" + "efg";
		try (ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes()); 
				ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			int i = 0;
			byte[] b = new byte[3];
			while((i = in.read(b)) != -1) {
				out.write(b, 0, i);
			}
			System.out.println(out.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
