package com.asiainfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("student")
public class StudentController {// 使用注解就无需再实现Controller接口
	@RequestMapping("/met1")
	public String met1() {
		return "/index.jsp";
	}
	
	@RequestMapping("/met2")
	public ModelAndView met2() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/index.jsp");
		modelAndView.addObject("studentName", "张三");
		return modelAndView;
	}
}
