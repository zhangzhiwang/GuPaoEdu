package com.asiainfo.p5.designPatterns.carp;

import com.asiainfo.p5.designPatterns.lsp.Father;

/**
 * 合成复用原则CARP（Composite/Aggregate Reuse Principle）：优先使用组合或者聚合而不是继承来达到代码复用的目的，减少类之间的耦合。
 *
 * @author zhangzhiwang
 * @date Feb 20, 2020 1:29:57 PM
 */
public class CARP {
	/**
	 * 首先继承有其弊端，比如破坏了封装、加强了类之间的耦合，那么既要实现代码的复用又想避免继承的弊端可以使用聚合来代替继承。A聚合B，就是在A类里面持有一个B类的成员变量。A类和B类是完全独立的，A类可以使用B类的对象来调用B类的方法或者属性，达到对B类代码复用的目的。

下面说一下继承、关联、聚合、组合的区别：

1、继承

不用多说了，A继承B，那么A就是B，但反过来B不一定是A。所以继承是is-a的关系，是一种纵向的关系。

2、关联

关联是两个类之间有联系，这种联系是很微弱的或者说是临时的，比如人过河要坐船，人和船就产生了联系，但是这种联系是临时的，人过了河就跟船没关系了。表现在代码层面就是A关联B，那么B以A的成员变量的形式存在在类A中。

3、聚合

聚合是关联关系的一种，也是两个事物要产生关系，但是这个关系的强度要大于关联关系，不是微弱或者临时的，是比较长久的关联，比如员工和公司的关系。但是这种互相关联的两个对象彼此又是独立的，各有各的生命周期，如果拆散这种关系那么各自也能玩儿的转。就好比员工和公司是一种长期的关系，但是公司和员工是彼此独立的，各有各的生命周期，公司没有张三这个员工也能玩儿的转，反过来张三不在这个公司去别的公司也玩儿的转。这种关系体现的是has-a的关系，代码表现和关联关系一样。

4、组合

组合是比聚合更紧密的关联关系，是一种强关联关系，具有组合关系的两个事物谁都不能缺少谁，如果断开这种关系各自都玩儿不转了，比如人和大脑的关系。这中关系是contains-a的关系，代码表现和关联关系一样。

所以从代码层面上看关联、聚合和组合表现形式都是一样的，得从语义上来区分，他们三个都是横向的关系。

那什么时候用继承又什么时候用组合呢？如果你要对现实世界建模，比如要描述狗类和动物的时候就要用继承，因为这些在概念上具有层次关系；如果你想表述你个实体要借助另一个实体来完成某项任务或者想表达has-a或者contains-a的时候就要用组合；如果只是在实现层面想达到代码复用的目的，那么优先使用组合。
	 */
	
	private Father father = new Father(); // CARP和father就是关联/聚合/组合关系，这三个在代码表现形式上是一样的要从具体的语义上区分，而具体的语义是什么就要结合业务来理解了。
	
	public void met1() {
		father.getUserList();
	}
}
