package com.asiainfo.p6_2020.designPatterns.proxy.staticProxy;

/**
 * 静态代理</p>
 * 优点：</p>
 * 1、隔离了客户端和被代理对象，起到了对被代理对象的保护作用，比如可以将被代理类不希望客户端访问的方法在代理类里面屏蔽掉，如本例的huntHouse方法</p>
 * 2、可以给被代理对象的方法进行增强</p>
 * 3、降低了客户端和被代理类的耦合</p>
 * 缺点：</p>
 * 1、静态代理硬性要求代理类和被代理类实现相同的接口，如果被代理类有很多，比如IDog、IPerson、ICat、IHouse等等，那么需要创建很多的代理类，增加系统类的数量</p>
 * 2、还是由于静态代理硬性要求代理类和被代理类实现相同的接口，那么如果接口增加方法的时候，不仅实现类需要改动，代理类也需要改动
 *
 *
 * @author zhangzhiwang
 * @date Mar 12, 2020 11:09:08 PM
 */
public class StaticProxyTest implements IEmployee {
	private IEmployee employee;

	public StaticProxyTest(IEmployee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public void huntJob() {
		System.out.println("做一些前置工作：收集信息");
		employee.huntJob();
		System.out.println("做一些收尾工作：收取中介费");
	}

	@Override
	public void huntHouse() {
		throw new UnsupportedOperationException("不支持找房子");
	}

	public static void main(String[] args) {
		IEmployee zhangSan = new LiSi();// new ZhangSan();
		StaticProxyTest staticProxyTest = new StaticProxyTest(zhangSan);
		staticProxyTest.huntJob();
		
		/**
		 * 静态代理的应用：我们常用的三层模型其实就可以看作静态代理——service是对dao的代理同时也是对dao功能的增强
		 */
	}

}
