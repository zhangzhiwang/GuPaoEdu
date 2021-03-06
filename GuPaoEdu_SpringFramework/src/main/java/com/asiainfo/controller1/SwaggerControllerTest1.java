package com.asiainfo.controller1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("group1")
public class SwaggerControllerTest1 {
	@GetMapping("/swaggerGroup1")
	public String swaggerGroup1() {
		return "swaggerGroup1...";
	}
}
