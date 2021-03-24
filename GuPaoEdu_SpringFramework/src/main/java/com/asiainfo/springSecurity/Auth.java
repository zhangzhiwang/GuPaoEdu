package com.asiainfo.springSecurity;

import lombok.Data;

/**
 * 认证实体类
 *
 * @author zhangzhiwang
 * @date 2021年3月18日 下午2:26:44
 */
@Data
public class Auth {
	private int id;
	private String loginName;
	private String loginPassword;
	private String salt;
	private int state;
}
