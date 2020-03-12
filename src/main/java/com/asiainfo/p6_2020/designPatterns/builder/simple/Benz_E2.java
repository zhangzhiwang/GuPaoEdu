package com.asiainfo.p6_2020.designPatterns.builder.simple;

import org.springframework.util.StringUtils;

/**
 * 按照建造者模式对Benz_E进行改造
 *
 * @author zhangzhiwang
 * @date Mar 12, 2020 5:40:10 PM
 */
public class Benz_E2 {
	// 无论什么配置座椅和轮胎是必须要有的否则无法构成一辆汽车
	private String seat;
	private String wheel;

	// 以下内容是选配，选择不同的配置对应不同等级的奔驰E产品：所有选配一个都不选的是低配，选一部分的是中配，全选的是高配
	private String navigation;// 车载导航
	private String loudSpeaker; // 汽车普通音响
	private String berlin;// 车载豪华高端音响——柏林之音，和汽车普通音箱二选一，也可以都不选但不能同时都选
	private String ceiling;// 汽车顶盖，不安装顶盖的是敞篷车
	private String sunroof;// 汽车天窗，选装有天窗的必须安装汽车顶盖
	private String refrigerator;// 车载冰箱
	private String lights;// 车内氛围灯作为夜晚的点缀
	private String tv;// 后座车载电视

	private Benz_E2(Benz_E2_Builder benz_E2_Builder) {
		this.seat = benz_E2_Builder.seat;
		this.wheel = benz_E2_Builder.wheel;
		this.navigation = benz_E2_Builder.navigation;
		// 这里控制高端音响和汽车普通音箱二选一，也可以都不选但不能同时都选
		if (!StringUtils.isEmpty(benz_E2_Builder.loudSpeaker) && !StringUtils.isEmpty(benz_E2_Builder.berlin)) {// 这个判断在原始的set方法里面无法实现，你把这个逻辑放到任何一个属性的set方法里面都不合适，因为你不知道另一个属性的set方法何时被调用
			throw new RuntimeException("高端音响和汽车普通音箱不能同时都选");
		}
		this.loudSpeaker = benz_E2_Builder.loudSpeaker;
		this.berlin = benz_E2_Builder.berlin;
		// 如果安装天窗就必须安装顶盖
		if (!StringUtils.isEmpty(benz_E2_Builder.sunroof) && StringUtils.isEmpty(benz_E2_Builder.ceiling)) {// 这个判断在原始的set方法里面无法判断，你把这个逻辑放到任何一个属性的set方法里面都不合适，因为你不知道另一个属性的set方法何时被调用
			throw new RuntimeException("安装天窗就必须安装顶盖");
		}
		this.ceiling = benz_E2_Builder.ceiling;
		this.sunroof = benz_E2_Builder.sunroof;
		this.refrigerator = benz_E2_Builder.refrigerator;
		this.lights = benz_E2_Builder.lights;
		this.tv = benz_E2_Builder.tv;
	}

	@Override
	public String toString() {
		return "Benz_E2 [seat=" + seat + ", wheel=" + wheel + ", navigation=" + navigation + ", loudSpeaker=" + loudSpeaker + ", berlin=" + berlin + ", ceiling=" + ceiling + ", sunroof=" + sunroof + ", refrigerator=" + refrigerator + ", lights=" + lights + ", tv=" + tv + "]";
	}

	public static class Benz_E2_Builder {
		private String seat;
		private String wheel;

		private String navigation;// 车载导航
		private String loudSpeaker; // 汽车普通音响
		private String berlin;// 车载豪华高端音响——柏林之音，和汽车普通音箱二选一
		private String ceiling;// 汽车顶盖，不安装顶盖的是敞篷车
		private String sunroof;// 汽车天窗，选装有天窗的必须安装汽车顶盖
		private String refrigerator;// 车载冰箱
		private String lights;// 车内氛围灯作为夜晚的点缀
		private String tv;// 后座车载电视

		public Benz_E2_Builder(String seat, String wheel) {
			super();
			this.seat = seat;
			this.wheel = wheel;
		}

		public Benz_E2_Builder addNavigation(String s) {
			navigation = s;
			return this;// 采用链式编程的方式比调用普通的set方法代码更优雅，可读性更高
		}

		public Benz_E2_Builder addLoudSpeaker(String s) {
			loudSpeaker = s;
			return this;
		}

		public Benz_E2_Builder addBerlin(String s) {
			berlin = s;
			return this;
		}

		public Benz_E2_Builder addCeiling(String s) {
			ceiling = s;
			return this;
		}

		public Benz_E2_Builder addSunroof(String s) {
			sunroof = s;
			return this;
		}

		public Benz_E2_Builder addRefrigerator(String s) {
			refrigerator = s;
			return this;
		}

		public Benz_E2_Builder addLights(String s) {
			lights = s;
			return this;
		}

		public Benz_E2_Builder addTv(String s) {
			tv = s;
			return this;
		}

		public Benz_E2 assembleBenz_E2() {
			return new Benz_E2(this);
		}
	}
}