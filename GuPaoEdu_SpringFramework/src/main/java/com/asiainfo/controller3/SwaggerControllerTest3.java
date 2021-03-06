package com.asiainfo.controller3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("group3")
@Api(tags = {"swagger测试"})
public class SwaggerControllerTest3 {
	@GetMapping("/swaggerGroup3")
	public String swaggerGroup3() {
		return "swaggerGroup3...";
	}
}
