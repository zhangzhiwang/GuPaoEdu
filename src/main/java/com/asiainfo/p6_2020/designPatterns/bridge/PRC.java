package com.asiainfo.p6_2020.designPatterns.bridge;

/**
 * 中华人民共和国
 *
 * @author zhangzhiwang
 * @date Mar 25, 2020 4:27:51 PM
 */
public abstract class PRC {// 注意这个类是“中国”继承体系的顶级抽象类，同时也承担了桥接的工作
	protected USA usa;// 将两个独立的继承体系关联起来的就在这里

	public PRC(USA usa) {
		super();
		this.usa = usa;
	}

	public abstract void speakChinese();
}
