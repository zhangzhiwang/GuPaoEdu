package com.asiainfo.lombok;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import lombok.Cleanup;

/**
 * @Cleanup 注解可以帮助程序员关闭流，程序中就不必显式地在finally中关闭流了
 *
 * @author zhangzhiwang
 * @date 2021年3月12日 下午12:58:37
 */
public class CleanupTest {
	public static void main(String[] args) {
		try {
			@Cleanup
			InputStream inputStream = new FileInputStream("/Users/zhangzhiwang/Desktop/1.png");
			@Cleanup
			OutputStream outputStream = new FileOutputStream("/Users/zhangzhiwang/Desktop/2.png");
			byte[] b = new byte[1024];
			int num = 0;
			while((num = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, num);
			}
			outputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
