package com.asiainfo.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.asiainfo.entity.User3;
import com.asiainfo.service.IUserService;
import com.asiainfo.service.IUserService2;
import com.asiainfo.service.impl.UserServiceImpl;

@Controller
//@Service
public class UserController {
	/**
	 * @Autowired：
		默认跟据类型匹配，如果类型有多个则根据名称匹配，如果按类型没有找到至少一个bean则直接报错。如果没有特殊指定，默认情况下会将标注了@Autowired注解的属性名作为bean的名称，由于@Autowired注解没有name属性，要特别指定注入bean的名称需要结合使用@Qualifier注解。
		
		@Resource:
		1、既不指定name也不指定type：默认将标注了@Resource注解的属性名作为bean的名称，并按照名称匹配，如果匹配不到按照该属性的类型进行配型匹配，如果都没有找到则抛出异常，如果按类型匹配时找到了多个该类型的bean也会跑异常。
		2、只指定name的值：则指按照名称匹配，如果名称匹配不到就抛异常
		3、只指定type的值：会按照指定的type进行类型匹配，但不是“只”按类型匹配（这一点很恶心）
		（1）如果没有匹配到任何bean，会将标注了@Resource注解的属性名作为bean的名称进行名称匹配，这时名称匹配肯定匹配不到，会抛异常，这个异常表达的是该属性的类型和按照名称匹配的类型不一致
		（2）如果匹配到了多个bean，则将标注了@Resource注解的属性名作为bean的名称进行名称匹配，如果匹配到了就注入，匹配不到才抛异常
		4、同时指定name和type属性：这是时候两个条件是“与”的关系，并且是先按照类型匹配，无论是否匹配到都要往下进行名称匹配。
	 */
	@Autowired
	@Qualifier("s2")
//	@Resource(name = "s1", type = IUserService.class)
	private IUserService userService;
//	@Autowired
	private User3 user;
	
	public User3 queryUser() {
		System.out.println(userService);
		System.out.println(user);
		return userService.queryUser();
	}

//	public IUserService getUserService() {
//		return userService;
//	}

//	public void setUserService(IUserService userService) {
//		this.userService = userService;
//	}
}
