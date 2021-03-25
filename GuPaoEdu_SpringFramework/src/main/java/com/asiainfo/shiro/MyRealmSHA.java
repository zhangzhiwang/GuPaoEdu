package com.asiainfo.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.SimpleRole;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;

/**
 * 自定义Realm，使用SHA加密
 *
 * @author zhangzhiwang
 * @date 2021年3月2日 下午10:12:52
 */
public class MyRealmSHA extends AuthorizingRealm {

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/**
		 * 注意：getPrimaryPrincipal方法的返回值是Object，该返回值可以转换为什么类型取决于认证doGetAuthenticationInfo方法的返回值对象的第一个字段是什么类型。
		 * 比如本例中doGetAuthenticationInfo方法返回的是SimpleAccount对象，构造方法的第一个参数是Object principal，实际传入的是String，那么在本方法中可以将getPrimaryPrincipal方法的返回值转换为String类型
		 */
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		System.out.println("SHA,MyRealm授权，userName = " + shiroUser.getUserName());
		
		// 根据userName到数据库查询该用户的角色，这里模拟查询结果
		String roleInDb1 = "admin";
		String roleInDb2 = "manager";
		
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addRole(roleInDb1);
		simpleAuthorizationInfo.addRole(roleInDb2);
		
		List<String> permissionList = new ArrayList<>();
		permissionList.add("insert");
		permissionList.add("query");
//		permissionList.add("USER_UPDATE");
//		permissionList.add("USER_DELETE");
		simpleAuthorizationInfo.addStringPermissions(permissionList);// 添加用户的权限
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证
	 * 返回null表示用户名不存在
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();// 客户端传入的用户名
		System.out.println("SHA客户端传入用户名：" + username);
		System.out.println("SHA客户端传入密码：" + new String(usernamePasswordToken.getPassword()));
		
		// 模拟数据库查询出来的User对象
		ShiroUser shiroUser = new ShiroUser("zhangsan", "123fe054047ff6694aa5550a0b130d98c558d7cb", "aaa");
		if(shiroUser == null) {// 用户名不存在（比如数据库没有查询出数据），返回null
			return null;
		}
		
		return new SimpleAccount(shiroUser, shiroUser.getPass(), new SimpleByteSource(shiroUser.getSalt()), "myRealm");
	}

}
