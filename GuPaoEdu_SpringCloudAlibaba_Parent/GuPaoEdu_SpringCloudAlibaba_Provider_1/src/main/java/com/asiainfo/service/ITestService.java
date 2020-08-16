package com.asiainfo.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * dubbo泛化。
 * 注意本接口没有放到api工程里面，而是放在了生产者的工程里面
 *
 * @author zhangzhiwang
 * @date Aug 15, 2020 10:10:35 PM
 */
//@Path("/")
public interface ITestService {
//	@Path("/test")
//	@GET
	String test(Integer id);
}
