package com.asiainfo.p5.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 基于缓冲的输入输出流
 *
 * @author zhangzhiwang
 * @date Jan 3, 2020 8:16:29 PM
 */
public class BufferedInputStreamTest {
	public static void main(String[] args) {
		try (// 基于缓冲的输入输出流内置了一个byte[]数组且默认大小为8k，其效果相当于不带缓冲的输入输出流然后自己定义一个8kb的byte[]数组
				BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("/Applications/Eclipse.app/Contents/Eclipse/workspace/GuPaoEdu/src/main/resources/Test.txt"), 3);) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
