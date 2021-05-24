package com.asiainfo.shiro;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * shiro配置类
 * spring整合shiro时shiro的配置是写在xml里面的，在spb中shiro的配置写在配置类里面，内容和xml的完全一样，可以看考GuPaoEdu_SpringFramework工程的配置文件shiro.xml
 *
 * @author zhangzhiwang
 * @date 2021年3月27日 下午5:50:50
 */
//@Configuration
public class ShiroConfig {
	@Bean
	public HashedCredentialsMatcher matcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");
		hashedCredentialsMatcher.setHashIterations(10);
		return hashedCredentialsMatcher;
	}
	
	@Bean
	public MyRealm myRealm(HashedCredentialsMatcher matcher) {
		MyRealm myRealm = new MyRealm();
		myRealm.setCredentialsMatcher(matcher);
		return myRealm;
	}
	
	@Bean
	public SecurityManager securityManager(MyRealm myRealm) {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(myRealm);
		return defaultWebSecurityManager;
	}
	
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl("/login.do");
		shiroFilterFactoryBean.setSuccessUrl("/success.jsp");
		shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth.jsp");
		
		Map<String, String> map = new HashMap<>();
		map.put("/login.do", "authc");
		map.put("/success.jsp", "authc");
		map.put("/login.jsp", "anon");
		map.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		return shiroFilterFactoryBean;
	}
	
	/**
	 * 开启shiro注解支持
	 * 
	 * @param securityManager
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年3月27日 下午6:39:45
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	
	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
		return defaultAdvisorAutoProxyCreator;
	}
}
