package com.asiainfo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * 自定义RoutePredicateFactory，需要继承AbstractRoutePredicateFactory，注意自定义的类名必须以“RoutePredicateFactory”结尾，前面的部分可以作为配置文件中的key
 *
 * @author zhangzhiwang
 * @date Dec 4, 2020 3:16:38 PM
 */
@Component
public class ZzwRoutePredicateFactory extends AbstractRoutePredicateFactory<ZzwRoutePredicateFactory.MyConfig> {

	public ZzwRoutePredicateFactory() {
		super(MyConfig.class);
	}

	static class MyConfig {
		private String zzwKey;// 可以作为配置文件中predicates下面的key为Zzw下面的key

		public String getZzwKey() {
			return zzwKey;
		}

		public void setZzwKey(String zzwKey) {
			this.zzwKey = zzwKey;
		}

	}

	@Override
	public List<String> shortcutFieldOrder() {
		return Arrays.asList("zzwKey");// 以快捷的方式使用key——zzwKey
	}

	@Override
	public Predicate<ServerWebExchange> apply(MyConfig config) {
		System.out.println("进入apply...");
		return exchange -> {
			HttpHeaders headers = exchange.getRequest().getHeaders();
			List<String> headerList = headers.get(config.getZzwKey()); // 来自于配置文件中配置的匹配规则
			if (headerList == null || headerList.size() == 0) {
				return false;
			}

			for (String value : headerList) {
				if ("abc".equals(value)) {
					return true;
				}
			}

			return false;
		};
	}

}
