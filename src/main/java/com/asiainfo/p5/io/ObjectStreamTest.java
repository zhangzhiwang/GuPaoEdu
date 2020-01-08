package com.asiainfo.p5.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象流
 *
 * @author zhangzhiwang
 * @date Jan 7, 2020 4:43:46 PM
 */
public class ObjectStreamTest {
	public static void main(String[] args) {
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/zhangzhiwang/Desktop/User.txt"));
				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/zhangzhiwang/Desktop/User.txt"))) {
			User user = new User(10, "zhangsan");// 内存中的对象，要想将对象实例化那么对象所属的类必须实现Serializable接口
			// 序列化：将内存中的对象写到磁盘上
			objectOutputStream.writeObject(user);
			
			// 反序列化：将磁盘中的对象读入到内存
			user = (User) objectInputStream.readObject();
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
