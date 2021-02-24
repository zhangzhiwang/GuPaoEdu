package com.asiainfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {// 使用注解就无需再实现Controller接口
	@RequestMapping("/met1")
	public String met1() {
		return "/index.jsp";
	}
}
