package com.asiainfo.p5.designPatterns.lsp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Son extends Father {
	@Override
	public void met1(Map h) {
	}// 重写规则1：子类重写父类的方法，那么方法名和参数列表必须完全一致。“完全一致”的意思就是子类方法的入參范围不能比父类的大或者小，而是完全相等。

	@Override
	public HashMap met2() {// 重写规则2：子类方法的返回值类型的范围不能比父类的大。
		return null;
	}

//	@Override
//	public HashMap met3(Map m) throws FileNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public void met4(LinkedHashMap m) {
		System.out.println("com.asiainfo.p5.designPatterns.lsp.Son.met4(int)");
	}

	public void met5(Map m) {
		System.out.println(1);
	}

	public void met5(HashMap m) {
		System.out.println(2);
	}

	@Override
	public List getUserList() {
		List list = null;

		try {
			System.out.println("do sth...");
			list = new ArrayList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;// 如果在实力化list之前抛异常的化那么list就为null
	}

	public static void main(String[] args) {
		Son f = new Son();
		f.met4(new LinkedHashMap());
	}
}
