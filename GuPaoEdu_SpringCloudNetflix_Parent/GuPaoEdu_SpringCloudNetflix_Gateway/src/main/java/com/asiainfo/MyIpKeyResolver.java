package com.asiainfo;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyIpKeyResolver implements KeyResolver {// 必须标注@Component

	@Override
	public Mono<String> resolve(ServerWebExchange exchange) {
		return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
	}
}
