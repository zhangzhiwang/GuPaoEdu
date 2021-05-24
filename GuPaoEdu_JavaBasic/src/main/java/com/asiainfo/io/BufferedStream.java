package com.asiainfo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 带缓冲区的流
 *
 * @author zhangzhiwang
 * @date 2021年4月15日 上午11:32:44
 */
public class BufferedStream {
	public static void copyWithBufferd1() {
		try  {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream("/Users/zhangzhiwang/Desktop/test.txt"));
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("/Users/zhangzhiwang/Desktop/test_2.txt"), 11);
			// 带缓冲的字节流里面维护了一个默认大小是8k的数组用来作为缓冲区，当然这个缓冲区的大小可以指定。
			int i = 0;
			/**
			 * 为什么带缓冲区的流自带了缓冲区，还需要程序员在外面自己定义缓冲数组呢？
			 * 比如带缓冲区的输出流，每次调用write()方法都是往缓冲区写数据，直到缓冲区满或者到达文件尾才往磁盘写入一次，如果程序员不自定义缓冲数组的话，那么out.write()是一个字节一个字节往缓冲区写的，
			 * 如果程序员自己定义了一个1k的数组，那么每次write会往自带的缓冲区写1k数据，效率当然高。
			 * 使用不带任何缓冲区的输出流，程序员自定义缓冲数组目的是减少每写一个字节都要和磁盘交互一次的开销；而使用带缓冲区的输出流时，程序员是否在外面自定义缓冲数组都不会影响和磁盘的交互次数，
			 * 因为这两种情况都是先往输出流自带的缓冲区写入数据，每满8k（默认值）才会和磁盘交互一次。但是如果不在外面指定数组，那么是一个字节一个字节地往自带的缓冲区写入数据，直到写满为止，
			 * 如果在外面自定义了1k的数组，那么是以1k为单位往自带缓冲区写数据，效率当然比前者高。所以，对于带缓冲区的输出流来说，程序员自定义的缓冲数组不是影响写出时和磁盘的交互次数，而是影响往自带的缓冲区写入数据的效率。
			 */
//			byte[] b = new byte[3];// 虽然说带缓冲区的流自带8k的缓冲区，但是外面自定义的byte数组也是有必要的。复制同一个文件可以比较一下copyWithBufferd1()和copyWithBufferd2()方法的执行时间。
			while((i = in.read()) != -1) {
//				out.write(b, 0, i);
				out.write(i);
			}
			
			// 带缓冲的输出流只有缓冲区满才会出发往磁盘写的动作，如果没有满就不会去写磁盘。在缓冲区没有满的情况下如果需要强制写磁盘就要调用flush方法，在close方法中也会调用flush方法。
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void copyWithBufferd2() {
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("/Users/zhangzhiwang/Desktop/jdk api 1.8_China.zip"));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("/Users/zhangzhiwang/Desktop/jdk api 1.8_China_2.zip"));) {
			int i = 0;
			while((i = in.read()) != -1) {
				out.write(i);
			}
			out.flush();// 1582ms
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void copyWithNormal1() {
		try (FileInputStream in = new FileInputStream("/Users/zhangzhiwang/Desktop/jdk api 1.8_China.zip");
				FileOutputStream out = new FileOutputStream("/Users/zhangzhiwang/Desktop/jdk api 1.8_China_2.zip");) {
			int i = 0;
			
			while((i = in.read()) != -1) {
				out.write(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void copyWithNormal2() {
		try (FileInputStream in = new FileInputStream("/Users/zhangzhiwang/Desktop/jdk api 1.8_China.zip");
				FileOutputStream out = new FileOutputStream("/Users/zhangzhiwang/Desktop/jdk api 1.8_China_2.zip");) {
			int i = 0;
			byte[] b = new byte[8192];
			while((i = in.read(b)) != -1) {
				out.write(b, 0, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		copyWithBufferd1();
//		copyWithNormal2();
		long end = System.currentTimeMillis();
		System.out.println((end - begin));
	}
}
