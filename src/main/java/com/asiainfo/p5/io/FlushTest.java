package com.asiainfo.p5.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 将缓冲区的数据刷到磁盘上
 *
 * @author zhangzhiwang
 * @date 2020年1月5日 下午2:10:40
 */
public class FlushTest {
	public static void main(String[] args) {
		BufferedOutputStream bufferedOutputStream = null;
		try {
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("/Users/zhangzhiwang/Desktop/aa.txt"), 4);
			
			bufferedOutputStream.write("hello".getBytes());
//			bufferedOutputStream.flush();// 当带缓冲的输出流里面的缓冲数组满时会自动往磁盘刷一次数据，如果用手动方式将缓冲数组的数据刷到磁盘就调用flush方法或者close方法。
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			try {
//				bufferedOutputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}
