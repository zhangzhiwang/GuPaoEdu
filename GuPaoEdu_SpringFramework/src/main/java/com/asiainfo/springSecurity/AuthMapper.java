package com.asiainfo.springSecurity;

import org.apache.ibatis.annotations.Param;

public interface AuthMapper {
	Auth getAuthByLoginName(@Param("loginName") String loginName);
}
