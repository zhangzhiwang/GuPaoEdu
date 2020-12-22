package com.asiainfo.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.asiainfo.entity.Product4;
import com.asiainfo.entity.Product5;

/**
 * @Import 注解动态引入的方式2——实现ImportBeanDefinitionRegistrar接口
 *
 * @author zhangzhiwang
 * @date Dec 19, 2020 2:27:08 PM
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 将要加入到ioc容器的类封装进RootBeanDefinition
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Product4.class);
		RootBeanDefinition rootBeanDefinition2 = new RootBeanDefinition(Product5.class);
		
		// 将RootBeanDefinition注册到BeanDefinitionRegistry
		registry.registerBeanDefinition("p4", rootBeanDefinition);
		registry.registerBeanDefinition("p5", rootBeanDefinition2);
	}
}
