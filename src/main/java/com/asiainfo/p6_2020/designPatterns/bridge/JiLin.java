package com.asiainfo.p6_2020.designPatterns.bridge;

public class JiLin extends PRC{

	public JiLin(USA usa) {
		super(usa);
	}
	
	@Override
	public void speakChinese() {
		usa.speakEnglish();
		System.out.println("说带东北口音的汉语");
	}

}
