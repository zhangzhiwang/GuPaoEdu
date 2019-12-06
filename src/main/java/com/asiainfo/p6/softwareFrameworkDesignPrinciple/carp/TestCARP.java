package com.asiainfo.p6.softwareFrameworkDesignPrinciple.carp;

/**
 * 合成复用原则（Composite/Aggregate Reuse Principle,CARP）：尽量用类的组合/聚合，而不是继承
 *
 * @author zhangzhiwang
 * @date Oct 22, 2019 1:33:42 PM
 */
public class TestCARP {
	/**
	 * 类和类之间的关系一共有6种：依赖、关联、聚合、组合、继承、实现，耦合度依次增强。
	 * 可参考：https://blog.csdn.net/kiki44944/article/details/81153804
	 */
	
	public void met1(A a) {// 1、依赖：一个类作为另一个类的方法入參或者局部变量的时候，这两个类就是依赖关系。本方法中A（入參）和TestCARP、B（局部变量）和TestCARP都是依赖的关系
		B b = new B();
		String str = b.toString();
		System.out.println(str);
		
		C.metC();// C（C类调用了它的静态方法）和TestCARP也是依赖关系
	}
}

class A {
	private B b = new B();// 2、关联：一个类作为另一个类的成员变量时，并且在成员变量定义时初始化，这两个类是关联关系。本例中，A和B是双向关联，A和C是单项关联。
	private C c = new C();
}

class B {
	private A a = new A();
}

class C {
	public static void metC() {}
}

// 学生上三和学生李四是平等的
class  ZhangSan {
	private LiSi liSi = new LiSi();// 张三和李四是关联关系，关联关系的类之间是平等的关系，不存在谁包含谁、谁拥有谁的关系，具有关联关系的类之间是相互独立的，离开了对方自己也可以单独存在。
								   // 张三和李四认识的时候李四这个对象就已经存在了，并不是张三生出来的，所以作为成员变量的对象要在定义时初始化。
}

class LiSi {
	private Car car;// 3、聚合：聚合关系是组合关系的一种，它所代表的两个类的关系强度要大于关联关系的。聚合关系的两个类之间是“拥有”的关系，两个类之间是独立的整体，在代码表现形式上和关联关系一样，也是一个类作为另一个类的成员变量，但一半是通过setter方法赋值。
					// 李四有一辆车，明显李四和车之间是拥有的关系没并且车可以独立于李四而存在，李四在临终前可以把车卖给别人，车就被别人拥有了。而且李四也不是生来就有辆车，是他大学毕业后工作几年攒下的钱买了一辆车，所以会用setter方法来进行赋值。
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}

class Car {}

class Person {
	private Hand hand;// 4、组合：组合是比聚合关系更紧密的一种关联关系，它的表现形式和关联和聚合一样，也是一个类作为另一个类的成员变量存在。但是他们之间的关系是同生共死的关系，并且作为成员变量的类不能独立存在，它只属于与它组合的类，不能被其他类共享。
					  // 人类都有手，手和人是同生共死的关系，人死了手存活也没有什么意义，人活着手没了也不行，而且一个人的手不能安在另一个人身上。手是在人出生的时候就有的，也就是要生出一个人必须也要生出他的手。
					  // 所以，组合关系是通过构造函数定义的。（继承和实现就不说了）
					  // 总结：其实关联、聚合、组合他们的代码表现是一样的，只不过语义不一样，对他们的解读不一样。
	public Person(Hand hand) {
		super();
		this.hand = hand;
	}
}

class Hand {}

