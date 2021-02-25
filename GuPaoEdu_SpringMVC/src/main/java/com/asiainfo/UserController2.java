package com.asiainfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component
@RequestMapping("user2")
@SessionAttributes({"age"})
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
	
	@RequestMapping(value = "/requestParam8", method = {RequestMethod.GET})
	@ResponseBody
	public void requestParam8(Date date) {
		System.out.println("date = " + date);
	}
	
	@RequestMapping(value = "/response1", method = {RequestMethod.GET})
	public String response1() {// 直接返回String，mvc会自动封装成ModelAndView，返回的字符串作为逻辑视图名
		return "/a/hello.jsp";// 注意：如果不配置视图解析器的前后缀的话，那么必须写全路径，如果在跟路径下前面必须写“/”，比如：“/index.jsp”
	}
	
	@RequestMapping(value = "/response2", method = {RequestMethod.GET})
	@ResponseBody// 将返回的字符串放到response的body里面返回给客户端
	public String response2() {
		return "/index.jsp";
	}
	
	@RequestMapping(value = "/response3", method = {RequestMethod.GET})
	public void response3() {
		System.out.println("response3");
	}
	
	@RequestMapping(value = "/response4", method = {RequestMethod.GET})
	public ModelAndView response4() {// 直接返回ModelAndView的效率更高，因为如果返回字符串的话mvc框架还要将其封装进ModelAndView，多了一步操作
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		return modelAndView;
	}
	
	@RequestMapping(value = "/response5", method = {RequestMethod.POST})
	public String response5() {
		return "redirect:/user2/response4";// 重定向
	}
	
	@RequestMapping(value = "/response6", method = {RequestMethod.GET})
	public void response6(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String param1 = (String) request.getAttribute("param1");// getAttribute一般用于转发，A转发到B，A在转发前可以先setAttribute，然后B在getAttribute，注意getAttribute之前必须先setAttribute
		String param1 = (String) request.getParameter("param1");//getParameter是获取客户端传过来对策参数
		System.out.println("param1 = " + param1);
		
		response.sendRedirect("/GuPaoEdu_SpringMVC/index.jsp");
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	@RequestMapping(value = "/getResContent1", method = {RequestMethod.GET})
	public ModelAndView getResContent1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/index.jsp");
		mav.addObject("userName", "张三");
		return mav;
	}
	
	/**
	 * 下面的getResContent2-4方法并没有返回ModelAndView，而是将返回数据保存进了入參里并放入request里面，所以在页面可以通过请求域对象requestScope进行获取，如果想把返回的数据同时放到session域里面，需要在类上面添加@SessionAttributes注解，value值是自定义的，只要和页面获取的值一致即可，这样页面就可以通过session域对象进行获取，比如sessionScope.age
	 */
	@RequestMapping(value = "/getResContent2", method = {RequestMethod.GET})
	public String getResContent2(Map<String, String> map) {
		map.put("userName", "李四");
		return "/index.jsp";
	}
	
	@RequestMapping(value = "/getResContent3", method = {RequestMethod.GET})
	public String getResContent3(Model model) {
		model.addAttribute("userName", "王五");
		return "/index.jsp";
	}
	
	@RequestMapping(value = "/getResContent4", method = {RequestMethod.GET})
	public String getResContent4(ModelMap modelMap) {// ModelMap是上面的Model和Map的结合形式，它既有Model的addAttribute方法又有Map的put方法
		modelMap.addAttribute("userName", "赵六");
		modelMap.put("age", 18);
		return "/index.jsp";
	}
}
