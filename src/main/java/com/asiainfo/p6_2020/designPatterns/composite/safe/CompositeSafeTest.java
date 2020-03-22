package com.asiainfo.p6_2020.designPatterns.composite.safe;

/**
 * 组合模式——使客户端可以以统一的方式来处理个别对象和组合对象
 *
 * @author zhangzhiwang
 * @date Mar 22, 2020 3:59:14 PM
 */
public class CompositeSafeTest {//组合模式的安全式写法
	public static void main(String[] args) {
		DirectorySafe root = new DirectorySafe("root", 0);
		DirectorySafe home = new DirectorySafe("home", 1);
		root.addChild(home);
		MyFileSafe a = new MyFileSafe("a.txt", 1);
		root.addChild(a);
		
		home.addChild(new DirectorySafe("admin", 2));
		home.addChild(new MyFileSafe("b.mp3", 2));
		
//		root.list();
//		System.out.println(root.getExtName());// 目录根本就没有获取扩展名的方法，所以既是客户端调用了该方法编译也会报错
//		a.list();
//		System.out.println(a.getExtName());
		
		/**
		 * 安全式写法是把树枝节点和叶子结点的共有方法抽取出来，各自特有的方法还在各自的类里面。这样做的好处是符合了接口隔离原则，坏处是破坏了依赖倒置原则，即客户端不能依赖接口抽象编程了，必须要判断是树枝节点还是叶子节点。</p>
		 * 安全式写法的优缺点：</p>
		 * 优点是客户端不会误调用树枝节点或叶子结点不存在的方法否则编译报错，缺点是客户端必须区分是什么类型的节点，这有悖于组合模式的初衷———使客户端可以以统一的方式来处理个别对象和组合对象。
		 */
	}
}
