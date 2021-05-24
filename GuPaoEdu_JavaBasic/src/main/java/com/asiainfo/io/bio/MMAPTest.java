package com.asiainfo.io.bio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 零拷贝——不需要内核空间到用户空间的拷贝
 * 基于MMAP实现零拷贝
 *
 * @author zhangzhiwang
 * @date 2021年4月23日 下午1:05:29
 */
public class MMAPTest {
	public static void main(String[] args) {
		try(FileChannel inChannel = FileChannel.open(Paths.get("/Users/zhangzhiwang/Desktop/1.png"), StandardOpenOption.READ);
				FileChannel outChannel = FileChannel.open(Paths.get("/Users/zhangzhiwang/Desktop/1_2.png"), StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.WRITE);) {
			MappedByteBuffer inBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
			MappedByteBuffer outBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
			
			byte[] b = new byte[inBuffer.limit()];
			inBuffer.get(b);
			outBuffer.put(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
