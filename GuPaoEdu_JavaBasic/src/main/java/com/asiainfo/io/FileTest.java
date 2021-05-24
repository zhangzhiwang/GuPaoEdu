package com.asiainfo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 需求：用户输入一个目录：打印出该目录及其子目录下的所有文件（不包含目录）
 *
 * @author zhangzhiwang
 * @date 2021年4月14日 下午3:26:35
 */
public class FileTest {
	public static void main(String[] args) {
		try (InputStream in = System.in;
				// 字节流传换成字符流
				InputStreamReader inputStreamReader = new InputStreamReader(in);
				// 带缓冲的Reader
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
			String path = bufferedReader.readLine();
			File file = new File(path);
			if(!file.exists() || !file.isDirectory()) {
				System.out.println("输入的不是目录或者目录不存在！");
			} else {
				printFile(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void printFile(File file) {
		File[] files = file.listFiles();
		if(files != null) {
			for(File f : files) {
				if(f.isDirectory()) {
					printFile(f);
				} else {
					System.out.println(f.getAbsolutePath());
				}
			}
		}
	}
}
