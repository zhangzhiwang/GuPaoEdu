package com.asiainfo.entity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@DependsOn({"user2"})// 依赖于名称为user2的bean，只有先实例化user2的bean之后才能实例化本类对象
public class Product3 {
	public Product3() {
		System.out.println("Product3无参构造器");
	}
}