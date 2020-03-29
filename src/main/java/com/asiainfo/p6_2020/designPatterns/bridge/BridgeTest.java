package com.asiainfo.p6_2020.designPatterns.bridge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 桥接模式——两个互不相干的继承体系独立发展，通过一个桥接类将两个继承体系建立关联，在桥接类中采用组合而不是继承的方式进行关联</p>
 * 桥接模式有两个维度：实现继承体系和抽象继承体系
 *
 * @author zhangzhiwang
 * @date Mar 25, 2020 3:52:25 PM
 */
public class BridgeTest {
	public static void main(String[] args) throws Exception {
		/**
		 * 桥接模式举个形象点的例子就好比中国和美国，中国按照社会主义独立发展，美国按照资本主义独立发展，两者互不相干，各发展各的。</p>
		 * 两个国家为了建立良好关系同时加强两国人民的交流，现在要在两个国家之间修一座桥梁，这个座桥就是桥接类，两个国家关系的建立是通过这个桥而不是谁继承谁。
		 */
		PRC bj = new Beijing(new Washington());
		bj.speakChinese();
		
		PRC jl = new JiLin(new California());
		jl.speakChinese();
		
		/**
		 * 桥接模式在源码中的应用：jdbc</p>
		 * jdbc是体现桥接模式的呢？首先要认识到jdbc是干什么的，jdbc屏蔽了底层数据库的差异，给程序员提供一个统一操作数据库的方式，也即是客户端是面向jdbc的api进行编程的，所以jdbc的API和客户端程序一起组成了桥接模式的抽象继承体系角色。</p>
		 * jdbc的API是接口啊，相当于客户端在干巴巴地调接口啊，没有实现啊，实现在哪里？我们知道不同数据库厂商各自会给出实现，那么各数据库厂商的实现就构成了桥接模式的实现继承体系角色。现在两个互不相干的继承体系已经有了，那么怎么把这两大体系联系在一起呢？得通过一座桥来实现，java.sql.DriverManager就扮演了这一角色。</p>
		 * 具体过成是：</p>
		 * 1、Class.forName("com.mysql.jdbc.Driver");导致JVM加载指定class文件，加载时会执行静态代码块，在静态代码块中将com.mysql.jdbc.Driver的实例注册到java.sql.DriverManager中，里面又一个list来保存注册的驱动实例。</p>
		 * 2、DriverManager.getConnection(...)从list中获取所有的驱动实例来循环获取连接并返回，返回的连接都是个数据库厂商自己实现的Connection。</p>
		 * 3、由于最开始返回的Connection是各厂商自己实现的java.sql.Connection子类，所以后续的过程（Statement、ResultSet）都是各厂商自己实现的。</p>
		 * 4、这样客户端的类（抽象体系中的某个类）就可以使用某个数据库厂商（实现体系中国呢的某个类）提供的功能了。</p>
		 * 整个过程的桥接点是java.sql.DriverManager中的registeredDrivers属性，我们也可以看到两个维度是各自发展的，互不干扰。
		 */
		
		
		
		// jdbc
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "zzw1234");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from t_course");
		connection.close();
	}
}

