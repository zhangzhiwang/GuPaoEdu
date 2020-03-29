package com.asiainfo.p6_2020.designPatterns.bridge;

/**
 * 华盛顿
 *
 * @author zhangzhiwang
 * @date Mar 25, 2020 4:23:42 PM
 */
public class Washington implements USA {

	@Override
	public void speakEnglish() {
		// TODO Auto-generated method stub
		System.err.println("说带华盛顿口音的英语");
	}

}
