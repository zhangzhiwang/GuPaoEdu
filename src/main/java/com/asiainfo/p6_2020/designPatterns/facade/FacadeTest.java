package com.asiainfo.p6_2020.designPatterns.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 门面模式——客户端只依赖一个总的接口就可以了，这个总接口往下去掉各子系统的分接口，减少客户端调用的复杂度</p>
 * 举一个具体的例子：电商系统，前端页面又一个下单付款的按钮，这个按钮点完之后要调用订单系统的接口，调用支付系统的接口，调用物流系统的接口，然后页面上显示订单信息、物流跟踪等，这样一个按钮前台就要调用过个系统的接口，增加了前台的复杂度。</p>
 * 如果后台只暴露给前台一个总接口，这样前台就调一个接口即可，然后这个总接口往下去调用各子系统的接口，这就是门面模式。门面模式给调用者屏蔽了子系统的细节， 无论子系统怎么变化客户端面对的是同一个门面。
 *
 * @author zhangzhiwang
 * @date Mar 5, 2020 9:13:16 AM
 */
public class FacadeTest {
	public static void main(String[] args) {
		// 模拟客户端不使用门面模式的场景,前台页面要调用三个系统的接口
		String s = "页面点击支付按钮";
		OrderSys.order(s);
		PaymentSys.pay(s);
		LogisticsSys.check(s);
		
		System.out.println("-------------");
		// 使用门面模式，客户端只需要调用一个总体接口即可
		GlobalSys.global(s);
		
		/**
		 *  门面模式与代理模式的区别：门面模式就是一种静态代理模式，只是侧重点不一样：代理模式侧重于增强，即在背带里对象调用方法的前后做一些操作，而门面模式强调封装，将各种子系统的接口封装成一个接口。
		 */
		
		/**
		 *  门面模式的实际应用案例：Spring jdbc中的JdbcUtils、Tomcat中的org.apache.catalina.connector.RequestFacade、MVC的Service层。</p>
		 *  通过这两个源码可以看出对门面模式的理解不能局限于上面举的页面支付按钮的例子——一个总接口里面去调用好多分接口。一个门面类可以只代理一个系统，假如这个系统的接口很多而且有一部分接口不希望对客户端暴露，那么就可以在门面类中屏蔽这些接口，所以“客户端->门面类A->子系统A”这种也是门面模式。</p>
		 *  比如Tomcat中的门面类RequestFacade只是对org.apache.catalina.connector.Request这一个类的代理，所以客户端想跟Request打交道必须通过门面类RequestFacade对象才能实现。</p>
		 *  其实静态代理中代理类没有做增强而是直接把请求转给被代理类对象，这种没有增强的静态代理就是门面了，它起到对子模块的保护作用和过滤作用，把子模块不想暴露的接口给过滤掉。
		 *  MVC的三层模型：Controller、Service、Dao，其中Service可以看作是Dao的门面。有时活Controller要调用好多Dao去实现一个整体的业务功能，不如加一个Service层，让它去调用不同的Dao，Controller调用一个Service接口就可以了。
		 */
	}
}
