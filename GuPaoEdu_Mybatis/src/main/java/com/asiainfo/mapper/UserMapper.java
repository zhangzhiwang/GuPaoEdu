package com.asiainfo.mapper;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.entity.User;

public interface UserMapper {
	User queryUserById(@Param("id") int id);
	
	int saveUser(@Param("u") User user);
}
