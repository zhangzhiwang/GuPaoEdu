package com.asiainfo;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器，注意全局过滤器和局部过滤器实现的接口不一样
 *
 * @author zhangzhiwang
 * @date Dec 5, 2020 4:05:14 PM
 */
@Component// 必须标注是一个Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

	@Override
	public int getOrder() {
		return 0;// spc对全局过滤器是有顺序要求的，值越小越优先
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("【PRE】");
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			System.out.println("【POST】");
        }));
	}

}
