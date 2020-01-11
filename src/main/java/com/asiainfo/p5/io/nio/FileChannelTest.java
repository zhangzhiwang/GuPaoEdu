package com.asiainfo.p5.io.nio;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * FileChannel
 *
 * @author zhangzhiwang
 * @date Jan 11, 2020 4:16:09 PM
 */
public class FileChannelTest {
	public static void main(String[] args) {
		try (FileChannel inChannel = FileChannel.open(Paths.get("/Users/zhangzhiwang/Movies/hulan.mp4"), StandardOpenOption.READ);
				FileChannel outChannel = FileChannel.open(Paths.get("/Users/zhangzhiwang/Desktop/hulan.mp4"), StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
			MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
			MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
			
			byte[] buffer = new byte[inMappedByteBuffer.limit()];
			inMappedByteBuffer.get(buffer);
			outMappedByteBuffer.put(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
