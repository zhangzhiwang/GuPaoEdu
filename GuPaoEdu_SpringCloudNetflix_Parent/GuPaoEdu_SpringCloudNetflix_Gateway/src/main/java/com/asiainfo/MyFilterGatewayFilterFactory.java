package com.asiainfo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

/**
 * 自定义局部过滤器，是局部过滤器不是全局过滤器
 *
 * @author zhangzhiwang
 * @date Dec 5, 2020 3:57:19 PM
 */
@Component// 必须加此注解
public class MyFilterGatewayFilterFactory extends AbstractGatewayFilterFactory<MyFilterGatewayFilterFactory.MyFilterConfig>{
	static class MyFilterConfig {
		private String myConfigName;

		public String getMyConfigName() {
			return myConfigName;
		}

		public void setMyConfigName(String myConfigName) {
			this.myConfigName = myConfigName;
		}
	}
	
	public MyFilterGatewayFilterFactory() {
		super(MyFilterConfig.class);
	}
	
	@Override
	public List<String> shortcutFieldOrder() {
		/**
		 * 此方法的目的是在application.yml配置文件中可以以简便的方式进行配置，如果不重写此方法，必须以标准的方式进行配置。
		 * 标准方式：
		 * filters:
             - name: MyFilter
             - args: myConfigName
            
            简化方式：
            filters：
              - MyFilter=myConfigName
		 */
		return Arrays.asList("myConfigName");
	}

	@Override
	public GatewayFilter apply(MyFilterConfig config) {
		return ((exchange, chain) -> {
            System.out.println("[Pred] Filter Request，Name : "+config.getMyConfigName());
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                String code=exchange.getResponse().getStatusCode().toString();
                System.out.println("[Post] Response Code : "+code);
            }));
        });
	}

}
