package com.asiainfo.lombok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.java.Log;
//import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * 注意：lombok提供了两个有关日志的注解：@Slf4j和@Log
 * @Slf4j 根据名称可以看出来底层使用的是slf4j，所以必须引入slf4j的相关jar包（slf4j-api和slf4j-log4j12，而且二者的版本最好一致），还要在classpath下加入配置文件log4j.properties才能生效
 * 		  如果没有引入slf4j的相关jar包而直接使用@Slf4j注解，编译会报错
 * @Log 注解底层依赖的是java.util.logging.Logger，所以不必引入slf4j依赖也没必要写配置文件
 * @author zhangzhiwang
 * @date 2021年3月11日 下午2:19:30
 */
@Slf4j
//@Log
public class LogTest {
	// 显示使用slf4j的方式，如果使用@Slf4j注解可以省略掉下面这行代码，lombok会自动加上这一行
//	private static final Logger LOG = LoggerFactory.getLogger(LogTest.class);
	// 使用@Log注解会自动生成下面这行代码，其中Logger是java.util.logging包下的
//	private static final Logger log = Logger.getLogger(LogTest.class.getName());
	
	public static void main(String[] args) {
//		LOG.debug("hello");
		log.info("world");
	}
}
