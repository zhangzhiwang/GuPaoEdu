package com.asiainfo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("GuPaoEdu-SpringCloudNetflix-Provider-Product")// 声明该类使用Feign客户端，参数是服务生产者的应用名称。Feign内置了Ribbon负载均衡器，通过服务生产者的应用名称从服务注册中心获取到生产者列表再通过内置的负载均衡算法得到被调用的ip和端口
															// Feign比使用RestTemplate更友好，更符合面向对象的特性
public interface IServiceFeign {
	@GetMapping("product/test1")// 作为http的调用方肯定得知道调用接口的url地址以及调用方式（POST、GET等），再加上上面获得的ip和端口，可以拼成调用url：ip:port/product/test1，调用方式是GET
	String testFeign();// 方法名可以自定义
}
