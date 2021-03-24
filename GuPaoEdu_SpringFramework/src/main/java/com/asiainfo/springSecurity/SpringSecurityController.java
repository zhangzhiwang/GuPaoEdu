package com.asiainfo.springSecurity;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ssc")
public class SpringSecurityController {
	@RolesAllowed({"admin_insert"})// jsr-250注解，表示具有admin_insert权限才能访问，否则报403
	@GetMapping("/helloSsc1")
	public String helloSsc() {
		return "helloSsc";
	}
	
	@PreAuthorize("hasAnyRole('admin_insert')")
	@GetMapping("/helloSsc2")
	public String helloSsc2() {
		return "helloSsc";
	}
	
	@Secured("admin_insert")// spring security注解
	@GetMapping("/helloSsc3")
	public String helloSsc3() {
		return "helloSsc";
	}
}
