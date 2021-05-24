package com.asiainfo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 输入流的read()方法测试
 *
 * @author zhangzhiwang
 * @date 2021年4月15日 上午9:51:41
 */
public class ReadTest {
	public static void main(String[] args) {
		try (FileInputStream in = new FileInputStream("/Users/zhangzhiwang/Movies/test.txt");
				) {
			int i = 0;
			byte[] b = new byte[in.available()];
			int count = 0;
			while((i = in.read(b)) != -1) {
				count++;
				System.out.print(i + " -> " + new String(b, 0, i));
				System.out.println();
//				System.out.println(i + " -> " + (char)i);
//				out.write(b, 0, i);
			}
			System.out.println("count = " + count);
			/**
			 * test.txt的内容是：abcdefg
			 * 实际打印的结果是：
			 *  abc
				def
				gef
				为什么g后面还有ef？
				原因是b数组的长度是3，所以它一次读取三个字节然后放到数组中。第一次数组是具有三个空元素的数组[][][]，当第一次读取后三个元素被填满[a][b][c]；
				第二次读取的时候又是一次性读三个字节，但是字节元素是一个一个替换的，比如第二次读取的时候限度第一个字节d，然后将d替换数组的第一个元素a，替换完是[d][b][c]，
				然后读取第二个字节e，替换数组第二个元素b，以此类推，第二次循环结束后数组变成了[d][e][f]；
				第二次循环完成后文件内容只有一个g没有读，但是g被安排到了第三次循环，第三次循环读取第一个字节g替换数组的第一个d，替换完是[g][e][f]，然后在读取第二个字节的时候发现已经到文件末尾了，返回了-1，读取文件结束，最后数组的后面两个元素根本就没有替换，所以结果是这么来的。
				怎么解决呢？这里要注意一个细节：无參的read()方法和read(byte b[])方法虽然后返回一个int值，但这这两个int值的含义不一样：前者返回的是下一个字节的ascii码的数字表示，比如a会返回97；而后者返回的是读取到的字节个数。那么本例中返回的字节个数分别是3、3、1。
				这样无论是转成字符串还是out写出都要指定数组、起始位置和读取的长度。
				那么作为缓冲的byte数组要设置多大呢？设置太小写出到磁盘时和磁盘的io次数会比较多，设置过大会占用过多的堆空间。最好的实践是使用in.available()，该方法返回剩余可以读到的字节总个数，既然是剩余肯定会每次的读取而逐渐变少，所以一般是第一次读之前使用。
				但是这种方式还要根据文件大小来取舍，如果文件过大，那么一次性读入所有内容内存压力会很大，所以要权衡利弊。
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
