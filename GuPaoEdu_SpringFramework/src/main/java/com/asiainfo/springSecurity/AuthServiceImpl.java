package com.asiainfo.springSecurity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
	@Autowired
	private AuthMapper authMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Auth auth = authMapper.getAuthByLoginName(username);
		if(auth == null) {
			return null;
		}
		
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		// 给登陆用户赋予角色
		list.add(new SimpleGrantedAuthority("admin_insert"));
		list.add(new SimpleGrantedAuthority("admin_update"));
//		UserDetails userDetails = new User(username, auth.getLoginPassword(), list);// 注意：这里的User类是org.springframework.security.core.userdetails包下的，不是自定义的
		UserDetails userDetails = new User(username, auth.getLoginPassword(),
				auth.getState() == 1,// 用户是否有效
				true,// 账户是否没有过期，true代表没过期
				true,// 密码是否没有过期，true代表没过期
				true,// 账户是否没被锁定，true代表没锁定
				list);
		return userDetails;
	}
}
