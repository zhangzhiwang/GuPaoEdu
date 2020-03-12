package com.asiainfo.p6_2020.designPatterns.builder.simple;

/**
 * 奔驰E级——不同的配置对应不同的产品，同样是汽车装配不一样产品就不一样，比如奔驰E级有低配、中配和高配但他们都是E级
 * </p>
 * 这个场景模拟了一个类有好多属性，而且部分属性之间是有依赖关系的，比如普通音箱和豪华高端音响是二选一的当然也可以都不选，选择天窗必须选择顶盖等
 *
 * @author zhangzhiwang
 * @date Mar 12, 2020 5:40:10 PM
 */
public class Benz_E {
	// 无论什么配置座椅和轮胎是必须要有的否则无法构成一辆汽车
	private String seat;
	private String wheel;

	// 以下内容是选配，选择不同的配置对应不同等级的奔驰E产品：所有选配一个都不选的是低配，选一部分的是中配，全选的是高配
	private String navigation;// 车载导航
	private String loudSpeaker; // 汽车普通音响
	private String berlin;// 车载豪华高端音响——柏林之音，和汽车普通音箱二选一
	private String ceiling;// 汽车顶盖，不安装顶盖的是敞篷车（敞篷车顶盖和天窗都不选）
	private String sunroof;// 汽车天窗，选装有天窗的必须安装汽车顶盖
	private String refrigerator;// 车载冰箱
	private String lights;// 车内氛围灯作为夜晚的点缀
	private String tv;// 后座车载电视

	// 奔驰提供了5个等级的E级轿车：只安装座椅和轮子的是低配，安装汽车普通音响和车载导航的是中配1，安装普通音响、车载冰箱和顶盖的是中配2，安装顶盖、天窗、氛围灯和电视的是中配3，所有全部安装的是高配，不管怎么选择配置都是奔驰E级

	/**
	 *  下面来看不用建造者模式的原始写法：构造函数和set/get方法。如果奔驰E类有100个属性，提供50个配置，那岂不要提供50个构造方法？你说不需要，只需要一个包括所有属性的总的构造方法就可以了，用户需要哪个就设置哪个不就可以了吗？</p>
	 *  呵呵...一个构造器50个参数不把你眼睛看花了，看花了不说，如果这些属性的类型相似（如本例中全是String）一不小心就会传错，比如把车载导航当作普通音响传进来。</p>
	 *  还一种解决方案就是必选项放在构造器中，其他的用set方法设置进来不就可以了吗？是可以，这种方式适用于属性比较少而且互相之间没有依赖关系，先设置谁后设置谁无所谓，但是如果出现这种场景你不好处理：</p>
	 *  你可以安装顶盖不安装天窗，但如果你安装天窗就必须安装顶盖。客户端要设置这两个属性的值必须分别调用各自的set方法，你无法控制客户端是否调用两次set方法，万一只调用一个属性的set方法就结束呢？并且你也无法控制客户端调用set方法的顺序，客户端压根可能就不知道某些属性之间还有顺序关系。
	 */
	// 按照5个等级的配置提供5个构造方法：

	/**
	 * 低配
	 * 
	 * @param seat
	 * @param wheel
	 */
	public Benz_E(String seat, String wheel) {
		super();
		this.seat = seat;
		this.wheel = wheel;
	}

	/**
	 * 中配1
	 * 
	 * @param seat
	 * @param wheel
	 * @param navigation
	 * @param loudSpeaker
	 */
	public Benz_E(String seat, String wheel, String navigation, String loudSpeaker) {
		super();
		this.seat = seat;
		this.wheel = wheel;
		this.navigation = navigation;
		this.loudSpeaker = loudSpeaker;
	}

	/**
	 * 中配2
	 * 
	 * @param seat
	 * @param wheel
	 * @param loudSpeaker
	 * @param ceiling
	 * @param refrigerator
	 */
	public Benz_E(String seat, String wheel, String loudSpeaker, String ceiling, String refrigerator) {
		super();
		this.seat = seat;
		this.wheel = wheel;
		this.loudSpeaker = loudSpeaker;
		this.ceiling = ceiling;
		this.refrigerator = refrigerator;
	}

	/**
	 * 中配3
	 * 
	 * @param seat
	 * @param wheel
	 * @param ceiling
	 * @param sunroof
	 * @param lights
	 * @param tv
	 */
	public Benz_E(String seat, String wheel, String ceiling, String sunroof, String lights, String tv) {
		super();
		this.seat = seat;
		this.wheel = wheel;
		this.ceiling = ceiling;
		this.sunroof = sunroof;
		this.lights = lights;
		this.tv = tv;
	}

	/**
	 * 全都选——高配
	 * 
	 * @param seat
	 * @param wheel
	 * @param navigation
	 * @param loudSpeaker
	 * @param berlin
	 * @param ceiling
	 * @param sunroof
	 * @param refrigerator
	 * @param lights
	 * @param tv
	 */
	public Benz_E(String seat, String wheel, String navigation, String loudSpeaker, String berlin, String ceiling, String sunroof, String refrigerator, String lights, String tv) {
		super();
		this.seat = seat;
		this.wheel = wheel;
		this.navigation = navigation;
		this.loudSpeaker = loudSpeaker;
		this.berlin = berlin;
		this.ceiling = ceiling;
		this.sunroof = sunroof;
		this.refrigerator = refrigerator;
		this.lights = lights;
		this.tv = tv;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getWheel() {
		return wheel;
	}

	public void setWheel(String wheel) {
		this.wheel = wheel;
	}

	public String getNavigation() {
		return navigation;
	}

	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}

	public String getLoudSpeaker() {
		return loudSpeaker;
	}

	public void setLoudSpeaker(String loudSpeaker) {
		this.loudSpeaker = loudSpeaker;
	}

	public String getBerlin() {
		return berlin;
	}

	public void setBerlin(String berlin) {
		this.berlin = berlin;
	}

	public String getCeiling() {
		return ceiling;
	}

	public void setCeiling(String ceiling) {
		this.ceiling = ceiling;
	}

	public String getSunroof() {
		return sunroof;
	}

	public void setSunroof(String sunroof) {
		this.sunroof = sunroof;
	}

	public String getRefrigerator() {
		return refrigerator;
	}

	public void setRefrigerator(String refrigerator) {
		this.refrigerator = refrigerator;
	}

	public String getLights() {
		return lights;
	}

	public void setLights(String lights) {
		this.lights = lights;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	@Override
	public String toString() {
		return "Benz_E [seat=" + seat + ", wheel=" + wheel + ", navigation=" + navigation + ", loudSpeaker=" + loudSpeaker + ", berlin=" + berlin + ", ceiling=" + ceiling + ", sunroof=" + sunroof + ", refrigerator=" + refrigerator + ", lights=" + lights + ", tv=" + tv + "]";
	}

}