package com.asiainfo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.asiainfo.controller.TestController;

@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	public void testService1() {
		LOGGER.debug("	service debug");
		LOGGER.info("	service info");
		LOGGER.error("	service error");
	}
}
