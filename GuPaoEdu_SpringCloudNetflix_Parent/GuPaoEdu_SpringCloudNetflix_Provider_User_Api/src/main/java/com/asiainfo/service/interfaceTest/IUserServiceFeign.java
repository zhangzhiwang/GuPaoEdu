package com.asiainfo.service.interfaceTest;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("GuPaoEdu-SpringCloudNetflix-Provider-User-Api")
public interface IUserServiceFeign extends IUserService {
	
}
