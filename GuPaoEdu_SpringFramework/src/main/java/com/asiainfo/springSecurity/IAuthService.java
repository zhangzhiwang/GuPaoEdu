package com.asiainfo.springSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAuthService extends UserDetailsService {// 注意：UserDetailsService是spring的security包下的，不是自定义的

}
