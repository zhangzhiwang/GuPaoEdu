package com.asiainfo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Restful是一种风格，是一种规范，不是一项具体的技术
 *
 * @author zhangzhiwang
 * @date 2021年2月25日 下午2:18:36
 */
@RestController
@RequestMapping("rest")
public class RestfulController {
	@GetMapping("/met1")
	public String query() {
		return "query...";
	}
	@PostMapping("/met1")
	public String insert() {
		return "insert...";
	}
	@PutMapping("/met1")
	public String update() {
		return "update...";
	}
	@DeleteMapping("/met1")
	public String delete() {
		return "delete...";
	}
}
