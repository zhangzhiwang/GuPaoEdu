package com.asiainfo.p5.designPatterns.lsp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReloadTest {
	public static void main(String[] args) {
		// 
		S s = new S();
		s.met(new LinkedHashMap());// LinkedHashMap是HashMap的子类，HashMap是Map的子类
		// 最终结果会调用子类的还是父类的met方法？
	}
}

class F {
	public void met(HashMap h) {
		System.out.println("F");
	}
}

class S extends F {
	public void met(Map h) {
		System.out.println("S");
	}
}