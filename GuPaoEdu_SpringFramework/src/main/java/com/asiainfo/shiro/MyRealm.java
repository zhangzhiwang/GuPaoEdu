package com.asiainfo.shiro;

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
 * 自定义Realm
 *
 * @author zhangzhiwang
 * @date 2021年3月2日 下午10:12:52
 */
public class MyRealm extends AuthorizingRealm {

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/**
		 * 注意：getPrimaryPrincipal方法的返回值是Object，该返回值可以转换为什么类型取决于认证doGetAuthenticationInfo方法的返回值对象的第一个字段是什么类型。
		 * 比如本例中doGetAuthenticationInfo方法返回的是SimpleAccount对象，构造方法的第一个参数是Object principal，实际传入的是String，那么在本方法中可以将getPrimaryPrincipal方法的返回值转换为String类型
		 */
		String userName = (String) principals.getPrimaryPrincipal();
		System.out.println("MyRealm授权，userName = " + userName);
		
		// 根据userName到数据库查询该用户的角色，这里模拟查询结果
		String roleInDb1 = "role3";
		String roleInDb2 = "role4";
		
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		return null;
	}

	/**
	 * 认证
	 * 返回null表示用户名不存在
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();// 客户端传入的用户名
		String userNameInDb = "liming";// 模拟数据库查出来的用户名
//		String passwordInDb = "111";// 模拟数据库查出来的密码
		String passwordInDb = "5816bd8c3cf33169a7a9e3fada69049d";// 模拟数据库查出来的密码的密文
		String saltIdDb = "abc";// 从数据库查出来的盐值
		if(!userNameInDb.equals(username)) {// 用户名不存在，返回null
			return null;
		}
		
//		return new SimpleAccount(userNameInDb, passwordInDb, "myRealm");
		return new SimpleAccount(userNameInDb, passwordInDb, new SimpleByteSource(saltIdDb), "myRealm");
	}

}
