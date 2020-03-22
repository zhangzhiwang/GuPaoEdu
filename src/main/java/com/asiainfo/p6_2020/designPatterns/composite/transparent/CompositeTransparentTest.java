package com.asiainfo.p6_2020.designPatterns.composite.transparent;

/**
 * 组合模式——使客户端可以以统一的方式来处理个别对象和组合对象
 *
 * @author zhangzhiwang
 * @date Mar 22, 2020 3:59:14 PM
 */
public class CompositeTransparentTest {//组合模式的透明式写法
	public static void main(String[] args) {
		/**
		 * 组合模式的使用场景使任何具有树形结构的场合，比如树形菜单、公司组织结构、文件系统等，客户端可以以一致的方式来处理树形结构中的任意组成部分而无需对不同的类型作判断</p>
		 * 组合模式有三个角色：</p>
		 * 1、所有组成部分（树枝节点和叶子结点）的抽象</p>
		 * 2、树枝节点</p>
		 * 3、叶子结点
		 */
		FileSystem root = new Directory("root", 0);
		Directory home = new Directory("home", 1);
		root.addChild(home);
		MyFile a = new MyFile("a.txt", 1);
		root.addChild(a);
		
		home.addChild(new Directory("admin", 2));
		home.addChild(new MyFile("b.mp3", 2));
		
//		root.list();
		System.out.println(root.getExtName());
//		a.list();
//		System.out.println(a.getExtName());
		
		/**
		 * 透明式写法将树枝节点和叶子结点公有的和不公有的方法都抽象到顶层抽象类里面，这样用户可以完全一致地对待树枝节点和叶子结点。</p>
		 * 但缺点是违背了接口隔离原则，即树枝节点或者叶子结点可能会以来不需要的接口，当用户调用这些接口时抛出UnsupportedOperationException异常，这样会使用户很迷惑：明明有这个api调用的时候还抛异常。
		 */
		
		/**
		 * 组合模式在源码中的应用：Collection</p>
		 * Collection可以看作是组合模式的抽象类角色，它包含了所有树枝节点和叶子结点的共有方法。Collection体系结构很复杂，其中有树枝节点（有子类的类）和叶子结点（没有子类的类），这些节点都有add方法、addAll方法、size方法等等，这样客户端就可以按照统一的方式来处理树枝节点和叶子结点了。
		 */
	}
}
