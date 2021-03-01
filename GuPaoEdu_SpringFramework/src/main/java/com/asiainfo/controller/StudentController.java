package com.asiainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.service.IStudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	private IStudentService studentService;
	
	@GetMapping("/met1")
	public void met1() {
		studentService.met1();
	}
}
