package com.asiainfo.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.asiainfo.entity.Order;
import com.asiainfo.entity.Product;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 将需要被spring托管的类型封装进RootBeanDefinition对象中
		RootBeanDefinition rootBeanDefinition1 = new  RootBeanDefinition(Order.class);
		registry.registerBeanDefinition("order", rootBeanDefinition1);
		
		RootBeanDefinition rootBeanDefinition2 = new  RootBeanDefinition(Product.class);
		registry.registerBeanDefinition("product", rootBeanDefinition2);
	}
}
