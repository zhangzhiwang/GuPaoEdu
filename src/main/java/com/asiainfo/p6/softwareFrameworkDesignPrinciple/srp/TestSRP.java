package com.asiainfo.p6.softwareFrameworkDesignPrinciple.srp;

/**
 * 单一职责原则（Simple Responsibility Principle）：一句话——一个类或者方法只干一件事情，这样做一个是结构清晰，便于维护，一个是降低不同逻辑的耦合性。</p>
 * 如果将不同逻辑的代码都卸载同一个类型或者方法里面，修改一个逻辑的代码有可能会影响到其他逻辑代码，风险会增大。
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 1:38:22 PM
 */
public class TestSRP {
	public void  met1() {
		// 新增一个用户
		
		// 修改一个用户
		
		// 删除一个用户
	}
	
	// 将上面一个方法的不同逻辑拆分成不同的方法
	public void insert() {}
	public void update() {}
	public void delete() {}
}
