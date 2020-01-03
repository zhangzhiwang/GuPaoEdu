package com.asiainfo.p5.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * InputStream的read方法
 *
 * @author zhangzhiwang
 * @date Jan 3, 2020 6:54:52 PM
 */
public class InputStreamReadTest {
	public static void main(String[] args) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream("/Applications/Eclipse.app/Contents/Eclipse/workspace/GuPaoEdu/src/main/resources/Test.txt");
			// 1、java.io.InputStream.read()
//			int read = inputStream.read();// 一次只读一个字节，返回读取到的下一个字节
//			System.out.println(read + " -> " + (char)read);
//			read = inputStream.read();
//			System.out.println(read + " -> " + (char)read);
//			read = inputStream.read();
//			System.out.println(read + " -> " + (char)read);
			
			// 2、java.io.InputStream.read(byte[])
			byte[] buffer = new byte[3];
			/**
			 * 官方注释：</p>
			 * Reads up to <code>b.length</code> bytes of data from this input</p>
			 * stream into an array of bytes. This method blocks until some input</p>
			 * is available.</p>
			 * @return     the total number of bytes read into the buffer, or</p>
			 *             <code>-1</code> if there is no more data because the end of</p>
			 *             the file has been reached.</p>
			 * 为什么要使用一个byte数组作为缓冲呢？因为不带参数的read方法每读一个字节就要和磁盘有一次交互，所以内存和磁盘交互的次数就是要读取文件的大小，比如文件有5k大小，那么内存就要和硬盘交互5000次。</p>
			 * 如果用read(byte[] b)方法，那么每次会读取b.length个字节，这样就减少了和磁盘交互的次数，最终和磁盘交互的慈湖可以估算为文件大小/b.length。</p>
			 * 这里要知道的是：作为缓冲区的字节数组的作用是用来告诉输入流或者输出流每次读取多少个字节并将读取到的字节放到这个数组中，而不是说这个数组是用来保存文件的所有字节的。</p>
			 * 比如说文件是5M，那么定义数组时byte[] buffer = new byte[5 * 1024 * 1024];就不对了，将buffer的长度定义为文件的大小就是误认为buffer是用来装文件所有字节的。</p>
			 * buffer长度的设置要合理，因为新建一个数组是需要开辟内存空间的，而且如果设置得过大比如设置成2M，那么一次从输入流里面读2M的数据效率也比较低，就不如设置小一点多读几次来的快。
			 */
//			int read = inputStream.read(buffer);// 从输入流中每次读取buffer.length个字节并放到buffer字节数组中
//			System.out.println(read);// 返回值和不带任何参数的read方法不一样，这个方法返回的是读取字节的个数，而上面的read方法返回的是下一个字节的值
//			System.out.println(new String(buffer));
			
			// 3、java.io.InputStream.read(byte[], int, int)
//			int read = inputStream.read(buffer, 0, 3);// 方法的返回值是实际读到的字节个数
//			System.out.println(read + " -> " + new String(buffer));
//			read = inputStream.read(buffer, 0, 3);
//			System.out.println(read + " -> " + new String(buffer));
//			read = inputStream.read(buffer, 0, 3);
//			System.out.println(read + " -> " + new String(buffer));
//			read = inputStream.read(buffer, 0, 3);
//			System.out.println(read + " -> " + new String(buffer));
			
			int i = 0;
			while((i = inputStream.read(buffer, 0, buffer.length)) != -1) {
				System.out.print(new String(buffer, 0, i));// 要想输出正确的结果那么String构造函数的第三个参数一定要是本次实际读到字节的个数i而不是数组长度buffer.length
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
