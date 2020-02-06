/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 通过序列化和反序列化实现深拷贝</p>
 * 和复写Object类的clone方法实现深拷贝不同的是通过序列化方法不能实现有的深拷贝有的浅拷贝，因为每次一层的复合类型都必须实现Serializable
 *
 * @author Administrator
 * @date 2020年2月2日 上午11:53:27
 */
public class DeepCopy2 implements Serializable {
	private int num;
	private A2 a;

/**
 * @param num
 * @param a
 */
public DeepCopy2(int num, A2 a) {
	super();
	this.num = num;
	this.a = a;
}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the a
	 */
	public A2 getA2() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA2(A2 a) {
		this.a = a;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeepCopy [num=" + num + ", a=" + a + "]";
	}

	public static void main(String[] args) {
		C2 c = new C2(30, "CCC");
		B2 b = new B2(20, c);
		A2 a = new A2(10, b);
		DeepCopy2 deepCopy = new DeepCopy2(100, a);
		
		// 序列化对象
		try(
				// 序列化对象
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:\\zzw\\deepcopy\\DeepCopy2.txt"));
				// 反序列化对象
				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:\\\\zzw\\\\deepcopy\\\\DeepCopy2.txt"));
				) {
			objectOutputStream.writeObject(deepCopy);
			objectOutputStream.flush();
			
			DeepCopy2 deepCopy2 = (DeepCopy2) objectInputStream.readObject();
			System.out.println(deepCopy);
			System.out.println(deepCopy2);
			
			// 测试深拷贝
			System.out.println("-------------------------");
			deepCopy.getA2().getB().getC2().setC(300);
			deepCopy.getA2().getB().getC2().setName("DDDddd");
			System.out.println(deepCopy);
			System.out.println(deepCopy2);
			
			System.out.println("-------------------------");
			deepCopy.getA2().getB().setB(2000);
			System.out.println(deepCopy);
			System.out.println(deepCopy2);
			
			System.out.println("-------------------------");
			deepCopy.getA2().setA(1000);
			System.out.println(deepCopy);
			System.out.println(deepCopy2);
			
			System.out.println("-------------------------");
			deepCopy.setNum(9);
			System.out.println(deepCopy);
			System.out.println(deepCopy2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
