package com.asiainfo.service.interfaceTest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.entityTest.User;

@FeignClient("GuPaoEdu-SpringCloudNetflix-Provider-User-Service")
@RestController
@RequestMapping("user")
public interface IUserService {// 和dubbo工程类似接口需要放到api工程中对外暴露，服务消费者和生产者通过api工程交互，只不过和dubbo不一样的是api工程里面的接口暴露的是http服务
	@GetMapping(value = "/getUser")
	String getUser(@RequestParam("s") String s);
	
	@GetMapping(value = "/insertUser")
	String insertUser(User user);
}