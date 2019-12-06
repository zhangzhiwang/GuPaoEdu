package com.asiainfo.p6.designPatterns.factory;

/**
 * 人工智能课程
 *
 * @author zhangzhiwang
 * @date Oct 22, 2019 8:54:20 PM
 */
public class AICourse implements ICourse {

	@Override
	public void record() {
		System.out.println("上AI课程");
	}

}
