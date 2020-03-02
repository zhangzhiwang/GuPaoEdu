package com.asiainfo.p6_2020.designPatterns.factory.factoryMethod;

import com.asiainfo.p6_2020.designPatterns.factory.entity.car.ICar;

/**
 * 工厂方法模式
 *
 * @author zhangzhiwang
 * @date Feb 23, 2020 11:16:20 PM
 */
public class FactoryMethodTest {
	public static void main(String[] args) {
		// 和简单工厂相比客户端的变化就是想要什么品牌的车就去找相关品牌的工厂去要，而不是一股脑地就找一个工厂去要
		// 想开奔驰就去奔驰工厂去要
		ICar benz = new BenzCarFactory().createCar();
		benz.run();

		// 想开奥迪就去奥迪工厂去要
		ICar audi = new AudiCarFactory().createCar();
		audi.run();

		// 想开宝马就去宝马工厂去要
		ICar bmw = new BMWCarFactory().createCar();
		bmw.run();
		
		/**
		 * 工厂方法模式的优缺点：</p>
		 * 优点：解决了简单工厂的指责不单一的问题</p>
		 * 缺点：每增加一种汽车就要新增一个汽车类和生产该汽车的工厂类，这样当汽车品牌很多的时候就会有大量的工厂类在工程里面，使类文件增多同时也使工程的体积变大。</p>
		 * 那怎么样既解决简单工厂的单一职责问题有尽可能地少创建工厂类呢？一个比较折中的方法就是扩大单一职责中“指责”的粒度。下面举例来说：</p>
		 * 现在各品牌的产品线丰富了，每个品牌不仅有轿车还有跑车和SUV，按照工厂方法模式，那么每种品牌就得有三个工厂，比如Audi有生产奥迪轿车的工厂A1，也有生产奥迪跑车的工厂A2还有生产奥迪SUV的工厂A3。</p>
		 * 这样每个工厂确实职责单一：A1只负责生产Audi的轿车，A2只生产Audi的跑车，A3只生产Audi的SUV。刚才在缺点里面也说了，一个品牌一个工厂，这样当有大量品牌加入的时候会产生大量的工厂类，导致类文件增多。这回可好，现在一个品牌有三个工厂了，类文件是原来的三倍了，更多了。</p>
		 * 那怎么办呢？就像上面所说折中的办法就是扩大“职责”的粒度，原来我们对“职责”的理解就是一个工厂只生产一个品牌的一种汽车，现在一个工厂生产一个品牌的所有种类的汽车但是它不负责生产其他品牌的，这也是单一职责，只不过我们要把“职责”的定义扩展一下，这样一来需要创建的工厂类就大大减少了，于是乎就诞生了抽象工厂模式。
		 */
		
		/**
		 *  工厂方法模式的应用场景：</p>
		 *  可以把Collection当作抽象工厂，这个工厂生产一种抽象的产品Iterator，生产产品的方法叫做iterator()。Collection的实现类可以看作是各种不同的具体工厂，比如ArrayList、HashSet、ArrayBlockingQueue等，它们都生产各自的具体的产品，这些产品都是Iterator的实现类。</p>
		 *  比如ArrayList通过实现iterator()方法生产java.util.ArrayList.Itr，HashSet通过实现iterator()方法生产java.util.HashMap.KeyIterator，ArrayBlockingQueue通过实现iterator()方法生产java.util.concurrent.ArrayBlockingQueue.Itr。
		 */
	}
}
