package com.asiainfo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(name = "GuPaoEdu-SpringCloudNetflix-Provider-Product")
@RestController
@RequestMapping("productSV")
public interface IProductService {// 通过feign暴露http接口
	@GetMapping("/getProductById")
	String getProductById();
}