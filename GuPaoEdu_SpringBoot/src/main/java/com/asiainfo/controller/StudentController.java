package com.asiainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.entity.Student;
import com.asiainfo.entity.Student2;
import com.asiainfo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/queryById/{id}")
	public String queryById(@PathVariable("id") int id) {
		Student student = studentService.queryById(id);
		return student.toString();
	}
	
	@GetMapping("/queryByIdWithJpa/{id}")
	public String queryByIdWithJpa(@PathVariable("id") int id) {
		Student2 student2 = studentService.queryByIdWithJpa(id);
		return student2.toString();
	}
}
