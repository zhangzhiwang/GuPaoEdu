package com.asiainfo.p6_2020.designPatterns.prototype;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 原型模式——说白了就是通过原有对象克隆出一个新对象
 *
 * @author zhangzhiwang
 * @date Mar 8, 2020 10:12:11 PM
 */
public class PrototypeTest implements Serializable {
	private int num;

	public PrototypeTest(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "PrototypeTest [num=" + num + "]";
	}

	public static void main(String[] args) {
		// 原型模式说白了就是深拷贝，没别的，就不写代码来举例子了。这里要注意一点的是既然是原型模式，那肯定是照着原型创建出来该类的另一个对象，所以它和单例模式是天生相反的，二者只能取其一。

		/**
		 * 原型模式的使用场景：
		 * </p>
		 * 1、构造方法里面的逻辑很复杂且很耗时，可以使用原型模式，因为对象的拷贝不会调用构造方法
		 * </p>
		 * 2、当一个对象有很多属性的时候，如果想创建一个相似的对象出来，那么就可以使用原型模式先克隆一个出来然后再修改个别属性，以防止过多地调用set/get方法导致代码可读性下降
		 * </p>
		 * 3、当一个对象需要被不同的调用者使用，并且不同的调用者会修改不同属性的值且互不干扰，可以使用原型模式
		 */

		/**
		 * 原型模式的实际应用：HashMap、ArrayList里面的clone方法都是深克隆
		 */

		ArrayList<PrototypeTest> list = new ArrayList<PrototypeTest>();
		list.add(new PrototypeTest(100));
		System.out.println(list);
		
		//ArrayList克隆方式1：
		ArrayList<PrototypeTest> list2 = (ArrayList<PrototypeTest>) list.clone();// ArrayList的clone方法的注释：Returns a shallow copy of this ArrayList instance.(The elements themselves are not copied.)所以是浅克隆
		System.out.println(list2);
		System.out.println(list == list2);
		
		System.out.println("-----------");
		list.get(0).setNum(200);
		System.out.println("list1 = " + list);
		System.out.println("list2 = " + list2);
		
		System.out.println("-----------");
		//ArrayList克隆方式2：Collections.copy()也是浅克隆
		List<PrototypeTest> list3 = Arrays.<PrototypeTest>asList(new PrototypeTest[1]);
		Collections.copy(list3, list);
		System.out.println("list3 = " + list3);
		System.out.println(list == list3);
		list.get(0).setNum(300);
		System.out.println("list1 = " + list);
		System.out.println("list3 = " + list3);

		System.out.println("-----------");
		// ArrayList实现深克隆——序列化
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/zhangzhiwang/Desktop/PrototypeTest.txt"));
				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/zhangzhiwang/Desktop/PrototypeTest.txt"))) {
			objectOutputStream.writeObject(list);
			objectOutputStream.flush();
			
			List<PrototypeTest> list4 = (List<PrototypeTest>) objectInputStream.readObject();
			System.out.println("list4= " + list4);
			System.out.println(list == list4);
			list.get(0).setNum(400);
			System.out.println("list1 = " + list);
			System.out.println("list4 = " + list4);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
