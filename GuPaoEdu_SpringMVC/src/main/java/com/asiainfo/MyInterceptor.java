package com.asiainfo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器
 *
 * @author zhangzhiwang
 * @date 2021年2月25日 下午1:43:29
 */
public class MyInterceptor implements HandlerInterceptor {
	/**
	 * 在执行controller的方法之前调用，本方法返回true代表通过或者放行，false代表不通过。
	 * 过滤器和拦截器各方法的执行时机可以参考图片/img/filter_interceptor.png
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("MyInterceptor.preHandle...");
		System.out.println("--------------");
		return true;
	}

	/**
	 * 执行完controller方法且在返回ModelAndView之前执行，该方法入參有一个ModelAndView，可以对即将返回的ModelAndView做处理
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterceptor.postHandle...");
		String viewName = modelAndView.getViewName();
		System.out.println("viewName = " + viewName);
		ModelMap modelMap = modelAndView.getModelMap();
		System.out.println("model = " + modelMap);
		
		modelAndView.addObject("interceptorAddParam", "拦截器在ModelAndView中添加数据");
		System.out.println("--------------");
	}

	/**
	 * 在controller返回完ModelAndView之后执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
		System.out.println("MyInterceptor.afterCompletion...");
	}
}
