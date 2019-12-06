package com.asiainfo.p6.designPatterns.factory.factoryMethod;

import com.asiainfo.p6.designPatterns.factory.ICourse;

/**
 * 工厂接口
 *
 * @author zhangzhiwang
 * @date Oct 22, 2019 10:29:44 PM
 */
public interface IFactory {
	ICourse create();
}
