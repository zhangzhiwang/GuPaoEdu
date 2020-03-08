package com.asiainfo.p6_2020.designPatterns.decorator;

/**
 * 装饰器模式——对某个类进行动态地扩展
 *
 * @author zhangzhiwang
 * @date Mar 5, 2020 3:09:56 PM
 */
public class DecoratorTest {
	public static void main(String[] args) {
		// 首先装饰器模式必须要有一个标配，任何DIY的装饰都是在标配的基础上进行的
		House standardHouse = new StandardHouse();
		
		// DIY一个沙发
		House houseWithSofa = new SofaDecorator(standardHouse);
//		System.out.println(houseWithSofa.desc());
//		System.out.println(houseWithSofa.price());
		
		
		// DIY一个沙发和衣柜
		House houseWithCloset = new ClosetDecorator(houseWithSofa);
//		System.out.println(houseWithCloset.desc());
//		System.out.println(houseWithCloset.price());
		
		System.out.println("---------");
		// 标配的基础上DIY两个沙发和三个衣柜
		houseWithSofa = new SofaDecorator(houseWithCloset);
		houseWithCloset = new ClosetDecorator(houseWithSofa);
//		houseWithCloset = new ClosetDecorator(houseWithCloset);
		System.out.println(houseWithCloset.desc());
		System.out.println(houseWithCloset.price());
		
		// 现在感觉三个衣柜有点多，撤掉一个衣柜，在上面注释掉一个衣柜即可
		
		/**
		 *  我们说装饰器模式必须要有一个产品的标配，其他的装饰都是在标配的基础上进行的，为了达到这个目的，除了标配以外其他任何装饰器和产品不能提供默认无参构造器，这样就强制要求最开始必须传入“标配”实体类。</p>
		 *  我们可以看到装饰器模式的模板里面有这几个角色：产品抽象、标准实现、继承了产品抽象的装饰器抽象、装饰器实现。其中：</p>
		 *  1、产品抽象和装饰器抽象既可以是接口也可以是抽象类</p>
		 *  2、标准实现至少要有一个，可以有多个</p>
		 *  3、继承了产品抽象的装饰器抽象这一角色可以省略掉，装饰器实现可以直接实现产品抽象，但一般要有这一角色
		 */
		
		/**
		 * 装饰器模式和继承的区别：</p>
		 * 装饰器模式和继承都可以扩展功能，但是装饰器模式是动态地扩展，而继承是静态的扩展、“写死”的扩展，子类对父类的扩展是写死在子类代码里的、变不了的，装饰器模式的扩展是“热插拔”的。</p>
		 * 
		 * 装饰器模式和代理模式的区别：</p>
		 * 代理模式是“别人帮你做事情”，装饰器模式是“你自己学会做事情”。比如我想吃饭但我不会做饭，我请一个保姆替我做饭，但是会做饭这个能力不属于我，属于保姆。现在我又想坐车但我不会开车，代理人保姆是不会给你开车的，她只代理做饭这件事情，其它事跟她无关，那你只能另请一个司机，但是做饭的能力和开车的能力不属于你，分别属于保姆和司机，和他俩在一起的时候你既可以吃饭也可以坐车,但是一旦离开了他们你就既不能吃饭也不能坐车，这就是代理模式</p>
		 * 代理类不是被代理类的子类，代理类被增强的那些功能不属于被代理类，当你不在调用代理类对象的时候那些增强的功能就通通消失了。而装饰器模式是自己学会做饭和开车，谁对自己功能的扩展，你到任何一个地方你还是你，你的扩展功能（新学会的能力）都会跟随着你，因为那些增强的功能是在子类里面实现的，相当于扩展自己。</p>
		 * 当被代理的顶层抽象类增加新的方法时，代理类Proxy不需要改代码，因为新增加的功能跟它没有关系，它和被代理对象是组合而不是继承的关系；但如果是在装饰器模式里被代理的顶层抽象类增加新的方法时，所有的子类包括辨准实现装饰器接口跟要跟着扩展。这就是它们的区别。
		 */
		
		/**
		 * 装饰器模式的实际应用：</p>
		 * Java IO。InputStream相当于产品抽象，FileInputStream、ByteArrayInputStream等相当于标准实现（标准实现可以有多个），FilterInputStream相当于继承了产品抽象的装饰器抽象，BufferedInputStream、DataInputStream等相当于装饰器实现。
		 */
	}
}
