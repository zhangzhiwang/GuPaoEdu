package com.asiainfo.p6_2020.designPatterns.builder.standard;

/**
 * 抽象建造者
 *
 * @author zhangzhiwang
 * @date Mar 12, 2020 7:59:29 PM
 */
public interface Builder {
	// 抽象建造者规定生产一辆车有两个步骤，但是它约束不了这两个步骤的顺序
	
	/**
	 * 创建车顶
	 * 
	 * @author zhangzhiwang
	 * @date Mar 12, 2020 8:00:23 PM
	 */
	Builder createCeiling();
	
	/**
	 * 创建天窗
	 * 
	 * @author zhangzhiwang
	 * @date Mar 12, 2020 8:00:52 PM
	 */
	Builder createSunroof();
	
	/**
	 * 组装一辆车
	 * 
	 * @return
	 * @author zhangzhiwang
	 * @date Mar 12, 2020 8:11:10 PM
	 */
	Car assembleACar();
}
