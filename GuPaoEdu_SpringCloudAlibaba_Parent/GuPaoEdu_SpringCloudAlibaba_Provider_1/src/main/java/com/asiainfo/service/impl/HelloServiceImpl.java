package com.asiainfo.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;

import com.asiainfo.service.api.IHelloService;

//@Service// 注意要使用阿里的@Service注解，而不是Spring的
@DubboService(version = "1", registry = {"beijing"})// 在新版本的dubbo里，为了避免程序员误将@Service使用成Spring的，所以特意提供了一个显得注解@DubboService来喝Spring的@Service注解区分开
// dubbo服务为什么要提供version？官方废除的说法是当服务出现不兼容的升级时需要使用版本号，在实际当中有一种场景是这样的：生产者服务出现了不兼容的升级，但是不要求所有的消费者都调用新的服务，
// 可以一部分消费者继续使用老服务，另一部分消费者可以使用新服务，即生产者同时暴露老服务和新服务，这个时候版本号就派上用场了，否则dubbo不知道消费者要调用新服务还是老服务
// 老服务注册中名称为“beijing”的注册中心
public class HelloServiceImpl implements IHelloService {

	public String hello() {
		return "Hello World!老服务";
	}
}
