package com.asiainfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gatewayFallback")
public class GatewayFallbackController {
	@GetMapping("/fallback")
	public String fallback() {
		return "GatewayFallback";
	}
}
