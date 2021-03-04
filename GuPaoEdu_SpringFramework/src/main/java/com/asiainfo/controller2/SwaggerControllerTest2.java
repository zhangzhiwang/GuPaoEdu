package com.asiainfo.controller2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("group2")
public class SwaggerControllerTest2 {
	@GetMapping("/swaggerGroup2")
	public String swaggerGroup2() {
		return "swaggerGroup2...";
	}
}
