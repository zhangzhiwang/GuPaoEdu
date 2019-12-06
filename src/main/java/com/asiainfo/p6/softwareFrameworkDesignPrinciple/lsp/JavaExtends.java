package com.asiainfo.p6.softwareFrameworkDesignPrinciple.lsp;

/**
 * 复习Java继承中方法复写的规则——"两同两小一大"原则
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 8:58:27 PM
 */
public class JavaExtends extends JavaExtendsFather{
	@Override
	public void met1(int i, double d, String s) {// 1、“两同”——方法名相同，参数列表相同（参数类型、个数、顺序必须完全相同）
		
	}
	
	@Override
	public Son met2() {
		/**
		 * )两小:
 *   2.1)子类方法的返回值类型小于或等于父类的
 *       2.1.1)void时，必须相同
 *       2.1.2)基本类型时，必须相同
 *       2.1.3)引用类型时，小于或等于
		 */
		return null;
	}
	
	@Override
	public void met3() throws MyException_Son {// 2.2)子类方法抛出的异常小于或等于父类的异常
		
	}
	
	@Override
	public void met4() {// 3)一大:子类方法的访问权限大于或等于父类的---访问控制修饰符后
		
	}
}

class JavaExtendsFather {
	public void met1(int i, double d, String s) {}
	
	public Father met2() {
		return null;
	}
	
	public void met3() throws MyException {}
	
	protected void met4() {}
}

class Father {}

class Son extends Father {}

class MyException extends Exception {}

class MyException_Son extends MyException {}