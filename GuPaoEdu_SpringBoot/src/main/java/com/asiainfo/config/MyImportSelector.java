package com.asiainfo.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	/**
	 * 返回值是要被spring托管的类全限定名数组
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		
		return new String[] {"com.asiainfo.entity.Order", "com.asiainfo.entity.Product"};
	}

}
