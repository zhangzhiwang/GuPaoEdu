package com.asiainfo.p6.designPatterns.factory.factoryMethod;

import com.asiainfo.p6.designPatterns.factory.AICourse;
import com.asiainfo.p6.designPatterns.factory.ICourse;

/**
 * AI课程工厂
 *
 * @author zhangzhiwang
 * @date Oct 22, 2019 10:30:27 PM
 */
public class AICourseFactory implements IFactory {
	@Override
	public ICourse create() {// 不需要外部传入参数来告诉生产什么产品，本工厂只生产一种特定的产品
		return new AICourse();
	}
	
}
