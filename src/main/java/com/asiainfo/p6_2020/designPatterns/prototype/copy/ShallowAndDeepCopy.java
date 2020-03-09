package com.asiainfo.p6_2020.designPatterns.prototype.copy;

/**
 * 浅拷贝和深拷贝
 *
 * @author zhangzhiwang
 * @date Mar 8, 2020 9:09:16 PM
 */
public class ShallowAndDeepCopy {
	public static void main(String[] args) {
		User user1 = new User(10, "zhangsan", new IdentityCard("131"));
		User user2 = user1.clone();
		System.out.println(user1 == user2);// 首先不说别的，浅拷贝出来的对象一定是一个新对象，是一个新的内存空间，和原对象地址一定是不同的，这一点和引用复制不一样

//		User user3 = user1;
//		System.out.println(user3 == user1);// 这不是浅拷贝，这是引用复制，两个引用指向同一对象
//
//		System.out.println("user1 = " + user1);
//		System.out.println("user2 = " + user2);
//		System.out.println("------------");
//
//		user2.setAge(20);
//		user2.setName("lisi");
//		user2.getId().setIdNum("666");
//		System.out.println("user1 = " + user1);
//		System.out.println("user2 = " + user2);
//		System.out.println("------------");
//		System.out.println(user2.getId() == user1.getId());
//
//		System.out.println("---------------------------");
//		// 深拷贝实现方式2——通过序列化实现深拷贝
//		User2 u = new User2(1, "aaa", new IdentityCard2("123"));
//		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/zhangzhiwang/Desktop/User.txt"));) {
//			objectOutputStream.writeObject(u);
//			objectOutputStream.flush();
//			
//			//反序列化
//			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/zhangzhiwang/Desktop/User.txt"));
//			User2 u2 = (User2) objectInputStream.readObject();
//			System.out.println(u2 == u);
//			System.out.println("u=" + u);
//			System.out.println("u2=" + u2);
//			u2.getId().setIdNum("456");
//			System.out.println("---------------------------");
//			System.out.println("u=" + u);
//			System.out.println("u2=" + u2);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
