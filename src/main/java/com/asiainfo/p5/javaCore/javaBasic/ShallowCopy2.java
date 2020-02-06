/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic;

/**
 * Object类的clone方法也是浅拷贝
 * </p>
 * 使用Object的clone方法要除以两点：1、被克隆对象所属的类要实现Cloneable接口
 * 2、被克隆的对象所属的类必须复写clone方法，原因是基于对protected访问控制权限的新认识。
 * </p>
 * 对protected访问控制权限的新认识：
 * </p>
 * 1、假如父类F有两个子类S1和S2，其中S1和父类不在同一个包中，那么S1通过S2的对象来访问F中的protected方法是不可以的而无论S2和F是不是在同一个包中
 * </P>
 * 2、如果S1和F在同一个包中，那么无论S2和F是不是在同一个包中S1都可以通过S2的对象来访问F的protected方法
 *
 * @author Administrator
 * @date 2020年2月2日 上午10:26:23
 */
public class ShallowCopy2 implements Cloneable {
	private int num;
	private String address;
	private User2 user;

	/**
	 * 
	 */
	public ShallowCopy2() {
		super();
	}

	/**
	 * @param num
	 * @param address
	 * @param user
	 */
	public ShallowCopy2(int num, String address, User2 user) {
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
	public User2 getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User2 user) {
		this.user = user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "ShallowCopy2 [num=" + num + ", address=" + address + ", user=" + user + "]";
	}

	@Override
	public ShallowCopy2 clone() throws CloneNotSupportedException {
		return (ShallowCopy2) super.clone();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		User2 user = new User2(10, "zs");
		ShallowCopy2 S1 = new ShallowCopy2(100, "beijing", user);
		System.out.println(S1);

		// 通过clone进行浅拷贝
		ShallowCopy2 S2 = S1.clone();
		System.out.println(S2);
		
		// 测试Object类的clone方法确实是浅拷贝
		System.out.println(S1.getUser() == S2.getUser());// 返回true，说明是浅拷贝。注意：User类没有实现Cloneable接口，在深拷贝当中得实现
		S1.getUser().setAge(20);
		S1.getUser().setName("ls");
		S1.setNum(200);
		S1.setAddress("tianjin");
		System.out.println("--------------------");
		System.out.println(S1);
		System.out.println(S2);
	}
}
