package com.asiainfo.controller2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("group2")
@Api(tags = {"描述1"})
public class SwaggerControllerTest2 {
	@GetMapping("/swaggerGroup2")
	public String swaggerGroup2() {
		return "swaggerGroup2...";
	}
	
	@GetMapping("/swaggerGroupTest1")
	public User swaggerGroupTest1() {
		return new User("张三", 18);
	}
	
	@PostMapping("/swaggerGroupTest2")
	@ApiOperation("添加用户")// 用于swagger页面中显示对方法的说明
	public User swaggerGroupTest2(@ApiParam("入參-用户信息") @RequestBody User u) {// @ApiParam注解用于swagger页面中显示对入參的说明
		return u;
	}
	
	@PostMapping("/swaggerGroupTest3")
	@ApiIgnore// 在swagger的api列表中不暴露此方法
	public User swaggerGroupTest3(@RequestBody User u) {
		return u;
	}
	
	@PutMapping("/swaggerGroupTest4")
	public void swaggerGroupTest4() {
	}
	
	@DeleteMapping("/swaggerGroupTest5")
	public void swaggerGroupTest5() {
	}
	
}
