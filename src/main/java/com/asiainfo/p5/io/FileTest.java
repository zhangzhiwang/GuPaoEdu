package com.asiainfo.p5.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 需求：与哦难怪乎在控制台输入一个路径，遍历该路径下（即其子路径）所有的文件名
 *
 * @author zhangzhiwang
 * @date Jan 2, 2020 1:45:28 PM
 */
public class FileTest {
	public static void main(String[] args) {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedInputStream = new BufferedReader(inputStreamReader);
		try {
			String path = bufferedInputStream.readLine();
			File file = new File(path);
			if(file.exists() && file.isDirectory()) {
				readFile(file);
			} else {
				System.out.println("\t" + file.getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bufferedInputStream.close();
				inputStreamReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void readFile(File file) {
		File[] fileList = file.listFiles();// 获取该路径下面的所有文件（包括目录），所以file必须为一个路径
		if(fileList != null && fileList.length != 0) {
			for(File f : fileList) {
				if(f.isDirectory()) {
					readFile(f);
				}
				
				System.out.println(f.getName());
			}
		}
	}
}
