package com.asiainfo.shiro;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiroController {
	@GetMapping("/role1")
	@RequiresRoles(value = {"role1", "role2"}, logical = Logical.OR)
	public String role1() {
		return "role1";
	}
	
	@GetMapping("/role2")
	@RequiresRoles(value = {"role1", "role2"})
	public String role2() {
		return "role2";
	}
}
