package com.asiainfo;

import java.util.List;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class MyBalanceRule extends AbstractLoadBalancerRule {

	/**
	 * 实现ip一致性hash算法，即同一个访问ip过来的请求会路由到同一个server
	 */
	public Server choose(Object key) {
		ILoadBalancer loadBalancer = getLoadBalancer();
		List<Server> serverList = loadBalancer.getReachableServers();
		int serverCount = serverList.size();
		if (serverCount == 0) {
			return null;
		}

		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		String ip = requestAttributes.getRequest().getRemoteAddr();// 客户端ip
		int ipHashCode = Math.abs(ip.hashCode());
		int index = ipHashCode % serverCount;

		return serverList.get(index);
	}

	public void initWithNiwsConfig(IClientConfig clientConfig) {
	}

}
