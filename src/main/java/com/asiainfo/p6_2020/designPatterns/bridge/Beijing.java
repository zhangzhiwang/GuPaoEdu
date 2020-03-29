package com.asiainfo.p6_2020.designPatterns.bridge;

public class Beijing extends PRC {

	public Beijing(USA usa) {
		super(usa);
	}
	
	@Override
	public void speakChinese() {
		usa.speakEnglish();
		System.out.println("说带北京口音的汉语");
		
	}

}
