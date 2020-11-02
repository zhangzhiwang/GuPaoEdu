package com.asiainfo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
@ConfigurationProperties("user")// 配置文件中属性的前缀
public class User {
	private int age;
	private String userName;
}
