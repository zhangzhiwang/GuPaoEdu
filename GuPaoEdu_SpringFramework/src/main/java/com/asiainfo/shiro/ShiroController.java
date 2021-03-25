package com.asiainfo.shiro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.manager.util.SessionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("shiroTest")
public class ShiroController {
	/**
	 * 页面访问login.do的时候并不会路由到此方法，此方法是认证没通过的时候才会调用
	 *
	 * @param request
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年3月13日 下午4:35:59
	 */
	@PostMapping("/login.do")
	public String login(HttpServletRequest request) {
		System.out.println("login...");
		Object attribute = request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		System.out.println("attribute = " + attribute);
		if(attribute != null){
            System.out.println(attribute.toString() + " ---- ");
        }
        return "/login.jsp";
	}
	
	@GetMapping("/shiro/queryUser")
	@RequiresRoles(value = {"manager", "admin_province1"}, logical = Logical.OR)// 需要相关的角色才能调用此方法，角色是数组可以传入多个，这些角色是“或者”的关系还是“与”的关系，取决于参数logical的值，通过看@RequiresRoles注解的源码可知logical默认是“与”
	public String queryUser() {
		System.out.println("queryUser...");
		Session session = SecurityUtils.getSubject().getSession();// shiro的session是独立的，可以单独使用，如果在web容器里和HttpSession是相通的，可以往HttpSession里面存放数据然后在shiro的session里面取出来
		String attribute = (String) session.getAttribute("keyTest");
		System.out.println("keyTest = " + attribute);
		System.out.println("----------------");
		String loginUserName = (String) session.getAttribute("loginUserName");
		String loginUserPass = (String) session.getAttribute("loginUserPass");
		System.out.println("loginUserName = " + loginUserName + ",loginUserPass = " + loginUserPass);
		return "/user.jsp";
	}
	
	@GetMapping("/shiro/setSession")
	public void setSession(HttpSession httpSession) {
		httpSession.setAttribute("keyTest", "valueTest");
	}
}
