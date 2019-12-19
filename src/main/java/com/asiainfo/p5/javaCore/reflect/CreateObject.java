package com.asiainfo.p5.javaCore.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 创建对象的四种方式
 *
 * @author zhangzhiwang
 * @date Dec 18, 2019 9:55:08 AM
 */
public class CreateObject implements Cloneable {
	public static void main(String[] args) throws Exception {
		// 1、通过new关键字
		CreateObject createObject = new CreateObject();
		
		// 2、通过反射
		Class<CreateObject> clazz = CreateObject.class;
		CreateObject createObject2 = clazz.newInstance();
		
		// 3、通过clone
		// 通过克隆创建对象该类必须实现标记接口Cloneable
		CreateObject clone = (CreateObject) createObject.clone();
		System.out.println(createObject == clone);
		
		// 4、通过反序列化创建对象
		// 序列化对象，该对象所属的类必须实现标记接口Serializable，否则会报java.io.NotSerializableException
		// 现将MyObject对象序列化
		MyObject myObject = new MyObject(1, "aa");
		OutputStream fileOutputStream = new FileOutputStream("MyObject.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(myObject);
		System.out.println("myObject对象序列化完成！");
		
		// 反序列化
		InputStream inputStream = new FileInputStream("MyObject.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		MyObject mo = (MyObject) objectInputStream.readObject();
		System.out.println(mo.toString());
	}
}
