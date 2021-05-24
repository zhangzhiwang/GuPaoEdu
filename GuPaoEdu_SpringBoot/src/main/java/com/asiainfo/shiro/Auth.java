package com.asiainfo.shiro;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Auth implements Serializable {
	private String userName;
	private String pass;
	private String salt;
}