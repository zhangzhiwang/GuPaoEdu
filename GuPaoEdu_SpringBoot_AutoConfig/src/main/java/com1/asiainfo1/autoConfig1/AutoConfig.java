package com1.asiainfo1.autoConfig1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com1.asiainfo1.service1.AutoConfigService;

@Configuration
public class AutoConfig {
	@Bean
	public AutoConfigService autoConfigService() {
		return new AutoConfigService();
	}
}
