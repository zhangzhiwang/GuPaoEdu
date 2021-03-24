package com.asiainfo.shiro;

import java.util.Arrays;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Shiro是apache的安全权限认证组件，本示例是单独使用shiro（没有和spring整合） 使用shiro的步骤： 1、引入相关依赖 2、编写配置文件：【自定义名称】.ini，文件名称可以自定义但是后缀必须是ini
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
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro_md5.ini");
		// 2、通过工厂获取SecurityManager对象
		SecurityManager securityManager = factory.getInstance();
		// 3、将SecurityManager对象添加到运行时环境中
		SecurityUtils.setSecurityManager(securityManager);
		// 4、获取Subject对象
		Subject subject = SecurityUtils.getSubject();
		// 5、将客户端提交的用户名密码封装进
		String userNameParam = "liming";// 模拟客户端提交的用户名密码
		String passwordParam = "12345";
		AuthenticationToken authenticationToken = new UsernamePasswordToken(userNameParam, passwordParam);
		// 6、认证
		try {
			subject.login(authenticationToken);
			System.out.println("认证通过");
		} catch (UnknownAccountException e) {// 用户名不对，用户不存在
			System.out.println("用户不存在");
		} catch (IncorrectCredentialsException e) {// 用户名存在但是密码错误
			System.out.println("密码错误");
		} catch (Exception e) {
			System.out.println("其它错误");
			e.printStackTrace();
		}

		// Md5Hash md5Hash = new Md5Hash("1234");
		// Md5Hash md5Hash = new Md5Hash("1234", "abc");
		// 用明文、盐值、加密次数三个参数一起来加密，得到的结果可靠性更高
		Md5Hash md5Hash = new Md5Hash("12345", // 明文，明文很容易破解
				"abc", // 盐值，用明文和盐值一起加密安全系数更高，但可能会被破解
				10);// 加密次数，将前一次的加密结果作为明文继续加密，一直循环加密到用户指定的次数为止
		System.out.println("md5Hash = " + md5Hash);
		System.out.println("--------------------");
		
		/**
		 * 认证和授权是两个概念，认证是就是识别该用户是不是系统认可的合法用户，说白了就是登陆；授权就是登陆进来之后这个用户可以访问系统的哪些资源，说白了就是访问权限。授权一定是通过了验证之后才有意义。
		 * 二者英文单词也不一样，认证是authentication，授权是authorization。
		 */
		// 验证授权，授权必须先通过认证
		boolean hasRole = subject.hasRole("role3");
		System.out.println("hasRole = " + hasRole);
		
		List<String> roleList = Arrays.asList("role1", "role3", "role2");
		boolean[] hasRoles = subject.hasRoles(roleList);
		for(boolean b : hasRoles) {
			System.out.println(b);
		}
		
		boolean hasAllRoles = subject.hasAllRoles(roleList);// 是否有列表里面所有的角色，列表中有一个角色没有就返回false
		System.out.println("hasAllRoles = " + hasAllRoles);
		
//		subject.checkRole("role1");// 如果包含制定角色则通过，否则抛异常
		
		boolean permitted = subject.isPermitted("queryzzw1");
		System.out.println("permitted = " + permitted);
		System.out.println("-----------------------------");
		
		boolean[] permitted2 = subject.isPermitted("insert", "update");
		for(boolean b : permitted2) {
			System.out.println(b);
		}
		
		boolean permittedAll = subject.isPermittedAll("insert", "update");// 类似上面的hasAllRoles方法
		System.out.println("permittedAll = " + permittedAll);
		
//		subject.checkPermission("insertzzw1");// 类似checkRole方法
		
		// shiro使用授权的方式有三种：一种是if/else，一种是注解，还有一种是通过页面标签，这里只测试第一种
		if(subject.hasRole("role1")) {
			System.out.println("执行新增和修改操作");
		} else if(subject.hasRole("role2")) {
			System.out.println("执行查询和删除操作");
		}
		
		Sha1Hash sha1Hash = new Sha1Hash("111", "aaa", 20);
		System.out.println("sha1Hash = " + sha1Hash);
	}
}
