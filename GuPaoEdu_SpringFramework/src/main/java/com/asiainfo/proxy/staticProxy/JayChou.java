package com.asiainfo.proxy.staticProxy;

import org.springframework.stereotype.Component;

@Component("zhouJieLun")
public class JayChou implements VocalConcert {
	@Override
	public void sing() {
		System.out.println("周杰伦开演唱会，唱歌");
	}

	@Override
	public String dance(int i) {
		System.out.println("周杰伦开演唱会，跳舞 : " + i);
		return "" + i;
	}
}
