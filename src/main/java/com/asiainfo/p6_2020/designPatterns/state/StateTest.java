package com.asiainfo.p6_2020.designPatterns.state;

/**
 * 状态模式——将系统的每种状态都独立成一个类，不懂的状态对应不同的行为，使状态和行为进行绑定，避免了if或者switch语句的判断</p>
 * 在平时的开发中，如果不使用状态模式，一种很普遍的实现方式是用数字表示不同的状态，然后用if-else或者switch判断，这样如果if的判断条件比较复杂或者状态比较多就会导致有大量的if判断语句以及可能会有多重嵌套的判断，这样可读性就非常差。一种很好的解决方案就是使用状态模式，将不同的状态独立成不同的类，当用到某个状态的时候就用相关的类即可。</p>
 * 状态模式的角色：</p>
 * 1、抽象状态角色</p>
 * 2、具体状态角色</p>
 * 3、上下文角色（用于切换状态）
 *
 * @author zhangzhiwang
 * @date Apr 23, 2020 12:46:22 PM
 */
public class StateTest {
	public static void main(String[] args) {
		/**
		 * 模拟场景：系统分为登陆和未登录状态，在登录状态下可以收藏文章，未登录状态下不可以收藏并跳转到登陆页面。
		 */
		
		Context context = new Context();
		context.favorite();
		
		// 状态模式在源码中的应用很少就不举例子了。
	}
}
