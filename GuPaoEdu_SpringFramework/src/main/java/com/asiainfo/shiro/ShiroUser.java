package com.asiainfo.shiro;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShiroUser implements Serializable {// rememberMe功能要求对象要序列化
	private String userName;
	private String pass;
	private String salt;
}