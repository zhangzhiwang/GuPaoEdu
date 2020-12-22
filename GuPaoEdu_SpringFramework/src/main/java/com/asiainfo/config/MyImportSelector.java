package com.asiainfo.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.asiainfo.entity.Product4;
import com.asiainfo.entity.Product5;

/**
 * @Import 注解动态引入的方式1——实现ImportSelector接口
 *
 * @author zhangzhiwang
 * @date Dec 19, 2020 2:27:08 PM
 */
public class MyImportSelector implements ImportSelector {

	/**
	 * 返回值是要加入Spring ioc容器的类的集合
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] {Product4.class.getName(), Product5.class.getName()};
	}

}
