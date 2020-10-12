package com.asiainfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class LogConfig {
	@Bean
	public Logger.Level feignLog() {
		return Logger.Level.FULL;
	}
}
