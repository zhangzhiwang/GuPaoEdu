package com.asiainfo.p6_2020.designPatterns.bridge;

/**
 * 加利福尼亚
 *
 * @author zhangzhiwang
 * @date Mar 25, 2020 4:25:13 PM
 */
public class California implements USA {

	@Override
	public void speakEnglish() {
		System.out.println("说带有加利福尼亚口音的英语");
	}

}
