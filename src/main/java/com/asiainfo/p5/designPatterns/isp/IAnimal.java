package com.asiainfo.p5.designPatterns.isp;

public interface IAnimal {// Animal就作为一个总的接口
	void eat(); // 任何动物都会吃
	void fly();// 狗和鸟都是动物的实现类，但是狗实现fly方法明显不合适因为它不会飞
	void swim();// 同理，鸟实现swim方法也不合适因为它不会游泳（个别会游泳的鸟比如企鹅除外）
	void runOnTheGround();// 马可以在陆地上奔跑，但是鱼不行
	
	// 要根据需求将一个总的接口拆分成三个小接口，实现的时候根据需求选择性地实现不同的接口即可
}
