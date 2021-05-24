package com.asiainfo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对西那个输入输出流，用于序列化和反序列化
 *
 * @author zhangzhiwang
 * @date 2021年4月15日 下午6:08:48
 */
public class ObjectInputStreamTest implements Serializable {
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		ObjectInputStreamTest test = new ObjectInputStreamTest();
		test.setAge(18);
		test.setName("zs");
		System.out.println("序列化前：" + test);

		ObjectInputStream in = null;
//		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/zhangzhiwang/Desktop/Test.mp3"));) {
//			out.writeObject(test);
		try {
			in = new ObjectInputStream(new FileInputStream("/Users/zhangzhiwang/Desktop/Test.mp3"));
			ObjectInputStreamTest readObject = (ObjectInputStreamTest) in.readObject();
			System.out.println("反序列化后：" + readObject);
			System.out.println(readObject.getAge() + " -> " + readObject.getName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
