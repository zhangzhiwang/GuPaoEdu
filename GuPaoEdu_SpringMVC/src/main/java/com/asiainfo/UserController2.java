package com.asiainfo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component
@RequestMapping("user2")
public class UserController2 {

	@RequestMapping(value = "/requestParam1", method = {RequestMethod.POST})
	@ResponseBody
	public String requestParam1(Integer id, String name) {// 入参不加任何注解那么请求参数必须和形参名一致才可以成功接收
		return id + " --- " + name;
	}
	
	/**
	 * 请求参数的名称和方法形参名称不一致，要使用@RequestParam注解，值要和请求参数名一致
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/requestParam2", method = {RequestMethod.GET})
	@ResponseBody
	public String requestParam2(@RequestParam(value = "ids", required = false, defaultValue = "111") Integer id, String name) {// 请求参数的名称和方法形参名称不一致，要使用@RequestParam注解，值要和请求参数名一致
		return id + " --- " + name;
	}
	
	@RequestMapping(value = "/requestParam3/{aaa}/{name}", method = {RequestMethod.GET})
	@ResponseBody
	public String requestParam3(@PathVariable("aaa") Integer id, @PathVariable("name") String name) {// @PathVariable和@RequestParam的区别是：如果请求路径里面有{***}要用@PathVariable且值和占位符的名称一致，如果url没有占位符，就使用@RequestParam
		return id + " --- " + name;
	}
	
	@RequestMapping(value = "/requestParam4", method = {RequestMethod.GET})
	@ResponseBody
	public String requestParam4(@PathVariable("aaa") Integer id, @PathVariable("name") String name) {// @PathVariable和@RequestParam的区别是：如果请求路径里面有{***}要用@PathVariable且值和占位符的名称一致，如果url没有占位符，就使用@RequestParam
		return id + " --- " + name;
	}
	
	@RequestMapping(value = "/requestParam5", method = {RequestMethod.POST})
	@ResponseBody
	public User requestParam5(User user) {// 如果参数较多，那么可以考虑封装成参数类，请求入参的名称和类属性名称一致即可，不需要加任何注解
		return user;
	}
	
	@RequestMapping(value = "/requestParam6", method = {RequestMethod.POST})
	@ResponseBody
	public void requestParam6(String[] arr) {// 入参是数组，如果是get请求则url应写成：http://localhost:8080/GuPaoEdu_SpringMVC/user2/requestParam6?arr=a&arr=b&arr=c，如果是post请求则url应该写成：http://localhost:8080/GuPaoEdu_SpringMVC/user2/requestParam6,参数的key是arr，value是a,b,c
		if(arr != null) {
			for(String s : arr) {
				System.out.println(s);
			}
		}
	}
	
	@RequestMapping(value = "/requestParam7", method = {RequestMethod.GET})
	@ResponseBody
	public void requestParam7(ArrayList<String> arr) {// 入参不能是集合接口，如List，否则报错；也不能是结合的实现类，比如ArrayList，虽然不报错，但是接收的参数是空，所以入参不能是接口类，但是集合和数组可以作为类的属性来进行传参，比如User类的hobbies和addresses，get或post请求的url写法见requestParam6方法
		if(arr != null) {
			for(String s : arr) {
				System.out.println(s);
			}
		}
	}
}
