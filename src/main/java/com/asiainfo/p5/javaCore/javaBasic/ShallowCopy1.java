/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic;

/**
 * 浅拷贝——值传递和引用传递。如果一个类里面有一个复合类型的属性，那么这个属性在往新对象拷贝的时候复制的是引用，也就是新老对象该属性的引用指向的是同一个对象。
 *
 * @author Administrator
 * @date 2020年2月2日 上午10:26:23
 */
public class ShallowCopy1 {
	private int num;
	private String address;
	private User user;

	/**
	 * 
	 */
	public ShallowCopy1() {
		super();
	}

	/**
	 * @param num
	 * @param address
	 * @param user
	 */
	public ShallowCopy1(int num, String address, User user) {
		super();
		this.num = num;
		this.address = address;
		this.user = user;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShallowCopy1 [num=" + num + ", address=" + address + ", user=" + user + "]";
	}

	public static void main(String[] args) {
		User user = new User(10, "zs");
		ShallowCopy1 S1 = new ShallowCopy1(100, "beijing", user);
		System.out.println(S1);

		// 浅拷贝
		ShallowCopy1 S2 = new ShallowCopy1();
		S2.setNum(S1.getNum());
		S2.setAddress(S1.getAddress());
		S2.setUser(S1.getUser());// s1和s2对象的User属性的引用指向了同一User对象
		System.out.println(S2);
		
		// 验证：s1和s2对象的User属性的引用指向了同一User对象
//		System.out.println(S1.getUser());// 测试时需注释掉User类的toString()方法
//		System.out.println(S2.getUser());
		
		// 由于s1和s2对象的User属性的引用指向了同一User对象，所以当s1对象改变User对象里面的某个属性的时候，通过s2对象的User属性引用去访问User对象时，该值也放生了变化
		S1.getUser().setAge(20);
		S1.getUser().setName("ls");
		System.out.println(S1.getUser());// 测试时需打开User类的toString()方法的注释
		System.out.println(S2.getUser());
		
		// 改变S1对象非复合类型的属性值不会影响S2对象的
		S1.setNum(200);
		S1.setAddress("tianjin");// 新生成一个字符串常量
		System.out.println(S1);
		System.out.println(S2);
	}
}
