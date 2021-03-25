package com.asiainfo.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
		ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
		System.out.println("-----当前登陆用户是：" + shiroUser.getUserName());
		
		Session session = subject.getSession();
		session.setAttribute("loginUserName", shiroUser.getUserName());
		session.setAttribute("loginUserPass", shiroUser.getPass());
		return super.onLoginSuccess(token, subject, request, response);
	}
}
