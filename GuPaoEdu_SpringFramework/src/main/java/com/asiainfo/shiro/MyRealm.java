package com.asiainfo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义Realm
 *
 * @author zhangzhiwang
 * @date 2021年3月2日 下午10:12:52
 */
public class MyRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * 返回null表示用户名不存在
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();// 客户端传入的用户名
		String userNameInDb = "wangwu";// 模拟数据库查出来的用户名
		String passwordInDb = "111";// 模拟数据库查出来的密码
		if(!userNameInDb.equals(username)) {// 用户名不存在，返回null
			return null;
		}
		
		return new SimpleAccount(userNameInDb, passwordInDb, "myRealm");
	}

}
