package com.asiainfo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Shiro是apache的安全权限认证组件，本示例是单独使用shiro（没有和spring整合）
 * 使用shiro的步骤：
 * 1、引入相关依赖
 * 2、编写配置文件：【自定义名称】.ini，文件名称可以自定义但是后缀必须是ini
 * 
 * shiro1.7.1的源码放在了本文件所在目录下，名为：shiro-root-1.7.1-source.zip
 *
 * @author zhangzhiwang
 * @date 2021年3月2日 下午9:22:40
 */
public class ShiroTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// 1、获取SecurityManager工厂类对象用于加载配置文件
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro2.ini");
		// 2、通过工厂获取SecurityManager对象
		SecurityManager securityManager = factory.getInstance();
		// 3、将SecurityManager对象添加到运行时环境中
		SecurityUtils.setSecurityManager(securityManager);
		// 4、获取Subject对象
		Subject subject = SecurityUtils.getSubject();
		// 5、将客户端提交的用户名密码封装进
		String userNameParam = "wangwu";// 模拟客户端提交的用户名密码
		String passwordParam = "111";
		AuthenticationToken authenticationToken = new UsernamePasswordToken(userNameParam, passwordParam);
		// 6、认证
		try {
			subject.login(authenticationToken);
			System.out.println("认证通过");
		} catch (UnknownAccountException e) {// 用户名不对，用户不存在
			System.out.println("用户不存在");
		} catch(IncorrectCredentialsException e) {// 用户名存在但是密码错误
			System.out.println("密码错误");
		} catch (Exception e) {
			System.out.println("其它错误");
			e.printStackTrace();
		}
	}
}
