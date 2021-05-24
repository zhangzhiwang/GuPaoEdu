package com.asiainfo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;

/**
 * 自定义Realm
 *
 * @author zhangzhiwang
 * @date 2021年3月27日 下午5:49:51
 */
public class MyRealm extends AuthorizingRealm {
	/**
	 * 认证
	 */
	@SuppressWarnings("unused")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();// 用户传过来的用户名
		char[] p = usernamePasswordToken.getPassword();
		String password = new String(p);// 用户传过来的密码
		System.out.println("用户穿过来的用户名：" + username + "用户传过来的密码：" + password);

		// 模拟根据用户名从数据库查出来的数据
		Auth auth = new Auth();
		auth.setUserName("zhangsan");
		auth.setPass("1234");
		auth.setSalt("abc");

		if (auth == null) {// 模拟从数据库没有查出数据
			return null;
		}

		return new SimpleAuthenticationInfo(password, auth.getPass(), // 数据库的密码
				new SimpleByteSource(auth.getSalt()), // 数据库的盐值
				"myRealm");// 自定义Realm的名称
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Auth auth = (Auth) principals.getPrimaryPrincipal();
		System.out.println("授权的账号是：" + auth.getUserName());

		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addRole("role1");
		return simpleAuthorizationInfo;
	}
}
