package com.asiainfo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * final与线程安全</br>
 * final可以防止指令重排序：</br>
 * 1、关于写final域
 * 	  对final域的写不能重排序到构造方法之外，即当外界获取到被构造的对象时，该对象所包含的final域已经被赋值。
 *    针对这一点还有一个补充规则——如果final域不是基本类型而是引用类型，那么对final域对象里面元素的写不能被重排序到构造方法之外
 * 2、关于读final域
 *    第一次对被构造对象的读要先于第一次对所构造对象的final域的读（初次读对象引用和初次读该对象包含的final域，JMM会禁止这两个操作的重排序），即当外界读取到被构造对象的final域时，该被构造的对象已经被读取
 * 可参考：https://blog.csdn.net/riemann_/article/details/96390511
 * 
 * @author zhangzhiwang
 * @date 2021年5月26日 下午8:21:03
 */
public class FinalTest {
	private int a;// 普通域
	private final int b;// final域，基本数据类型
	private final List<String> list;// final域，引用类型
	private static FinalTest finalTest;

	public FinalTest() {
		super();
		// 由于对a的赋值和对b的赋值不存在依赖关系，那么对这两个域的赋值可以在构造函数内进行重排序，但是b不能重排序到构造方法之外，a可以
		this.a = 1;// 写普通域，普通域的写可以被重排序到构造方法之外，即先完成构造方法再对里面的普通域进行赋值
		this.b = 2;// 写final域，对final域的写不能重排序到构造方法之外，因为对b赋值之后构造方法返回之前会拆入一个storestore屏障
		this.list = new ArrayList<>();// 写final域，对final对象进行赋值
		this.list.add("hello");// 写final域里面的元素
	}
//	this.a = 1; a可以被重排序到构造方法之外，b不行

	public static void met1() {// 假设线程A执行met1，且线程A先于线程B执行
		finalTest = new FinalTest();// 将被构造的对象复制给某一个引用，这样外界可以获取到这个被构造的对象。当外界已经获取到被构造的对象时，final域肯定已经被赋值过了，但是普通域不一定。
	}

	public static void met2() {// 假设线程B执行met2
		FinalTest f = finalTest;// 读取对象
		int a2 = f.a;// 读取对象普通域，第一次读取被构造对象f的普通域a时，f对象可能还没有被事先读取？？（这样不会有空指针吗？）
		int a3 = f.b;// 读取对象final域，第一次读取被构造对象f的final域b时，f对象已经事先被读取了
	}
	
	public void met3() {
		if(finalTest != null) {
			String s = finalTest.list.get(0);// 根据写final域的补充规则，当外界读到被构造对象时，在构造方法里面对被构造对象finalTest的final域list里面的元素的添加已经完成
		}
	}
}
