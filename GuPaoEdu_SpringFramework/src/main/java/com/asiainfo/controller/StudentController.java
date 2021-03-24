package com.asiainfo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.entity.Student;
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
	
	@GetMapping(value = "/met2", produces = "text/html;charset=utf-8")
	public String met2() {
		return "你好";
	}
	
//	@PostMapping(value = "/met", produces = "text/html;charset=utf-8")// produces属性防止通过@ResponseBody返回到页面的数据出现中文乱码
//	public String insert(@RequestBody Student student) {
//		studentService.insert(student);
//		return "插入成功！";
//	}
	
	@DeleteMapping(value = "/met", produces = "text/html;charset=utf-8")
	public String delete(long id) {
		studentService.delete(id);
		return "删除成功！";
	}
	
	@PutMapping(value = "/met", produces = "text/html;charset=utf-8")
	public String update(@RequestBody Student student) {
		studentService.update(student);
		return "修改成功！";
	}
	
	@PostMapping(value = "/met", produces = "text/html;charset=utf-8")
	public String query(long id) {
		Student student = studentService.query(id);
		List<Student> list = new ArrayList<>();
		list.add(student);
		return list.toString();
	}
	
	@PostMapping("/testDate")
	public void testDate(Date date) {
		System.out.println(date);
	}
}
