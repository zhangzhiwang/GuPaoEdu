package com.asiainfo.controller3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("group3")
public class SwaggerControllerTest3 {
	@GetMapping("/swaggerGroup3")
	public String swaggerGroup3() {
		return "swaggerGroup3...";
	}
}
