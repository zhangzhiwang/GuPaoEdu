package com.asiainfo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.asiainfo.entity.User;
import com.asiainfo.service.UserService;

@RestController
//@Controller
public class TestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@Value("${user.userName}")
	private String userName;
	@Autowired
	private User user;
	@Autowired
	private UserService userService;

	@GetMapping("/test1")
	public String test1() {
		System.out.println(user);

		LOGGER.debug("controller debug");
		LOGGER.info("controller info123");
		LOGGER.error("controller error");

		userService.testService1();
		return userName;
	}
	
	/**
	 * spb异常处理方式：
	 * 1、自定义错误页面
	 * 2、@ExceptionHandler 处理
	 * 3、@ControllerAdvice+@ExceptionHandler处理
	 * 4、SimpleMappingExceptionResolver处理
	 * 5、自定义HandlerExceptionResolver处理（实际上和第四种一样，只不过第四种是Spring一共了一个默认的实现，第五种方式是自己实现）
	 */
	@GetMapping("/test2")
	public String test2() {
		String s = null;
		s.length();// 此处抛空指针
		/**
		 *  spb默认的错误页面使用java代码拼接出来的，原理是：当系统抛出异常的时候spb会默认发送一个/error的url到默认的BasicErrorController，
		 *  该处理器处理错请求，会去/error路径下找错误页面，如果没有找到就会返回一个默认的错误页面，该页面的内容使用java代码拼接出来的。
		 *  如果想给所有的错误返回一个统一的错误页面，那就可以在/resources/templates下面创建一个error.html的页面（注意名字必须是error.html），同时要引入thymeleaf依赖。
		 *  但是这个功能必须得加thymeleaf依赖才能实现
		 */
		return userName;
	}
	
	@GetMapping("/test3")
	public String test3() {
		String[] ss = new String[1];
		System.out.println(ss[8]);// 数组越界
		return userName;
	}
	
	@GetMapping("/test4")
	public String test4() {
		userService.testService2();
		return userName;
	}
	
	@GetMapping("/testJedis")
	public void testJedis() {
		userService.test3();
	}
	
	/**
	 * 对特定异常做特殊处理，返回特定页面可以使用这种方式，在方法上标注@ExceptionHandler，里面的属性是需要映射的异常，该注解表明发生什么异常的时候调用次方法来处理。
	 * 这种异常处理的方式有两个缺点：
	 * 1、这种处理方式只嗯呢个处理本类发生的异常，其他类（比如TestController2）里面的异常是不能被捕获的
	 * 2、异常处理代码耦合到了业务代码中
	 * 解决这些缺点的做法就是把异常处理逻辑抽离出去，放在一个专门处理异常的处理器中，并在处理器的类定义处添加@ControllerAdvice注解，如本包中的ExceptionController.java
	 */
//	@ExceptionHandler(value = {NullPointerException.class})
//	public ModelAndView handleNullPointer() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("nullPointer");// 在/resources/templates下面创建相应的页面
//		return modelAndView;
//	}
//	
//	@ExceptionHandler(value = {ArrayIndexOutOfBoundsException.class})
//	public ModelAndView handleArrayIndexOutOfBoundsException() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("arrayIndexOutOfBounds");
//		return modelAndView;
//	}

	@PostMapping("/upload")
	public void upload(MultipartFile[] multipartFile) throws IllegalStateException, IOException {
		for (MultipartFile mulFile : multipartFile) {
			mulFile.transferTo(new File("/Users/zhangzhiwang/Desktop/" + mulFile.getOriginalFilename()));
		}
	}

	@PostMapping("/download")
	public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		File file = new File("/Users/zhangzhiwang/Pictures/WX20200915-094233@2x.png");
		InputStream inputStream = new FileInputStream(file);
		ServletOutputStream outputStream = response.getOutputStream();

		// 加上下面这两句话才可以正常导出
		response.setContentType("multipart/form-data");// 加这句话告诉浏览器返回的是一个文件
		response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());// 设置导出文件的名称
		
		byte[] bs = new byte[10240];
		int length = 0;
		while ((length = inputStream.read(bs)) > 0) {
			outputStream.write(bs, 0, length);
		}
		outputStream.flush();
		outputStream.close();
		inputStream.close();
	}
}
