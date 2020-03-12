package com.asiainfo.p6_2020.designPatterns.builder.standard;

import org.springframework.util.StringUtils;

/**
 * 汽车产品
 *
 * @author zhangzhiwang
 * @date Mar 12, 2020 7:57:35 PM
 */
public class Car {
	// 为了说明问题这里只用连个属性来演示
	private String ceiling;// 汽车顶盖，不安装顶盖的是敞篷车
	private String sunroof;// 汽车天窗，选装有天窗的必须安装汽车顶盖

	private String brand;

	public Car(String brand) {
		super();
		this.brand = brand;
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
		if(StringUtils.isEmpty(ceiling)) {
			new RuntimeException("安装天窗前必须安装顶盖");
		}
		this.sunroof = sunroof;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car [ceiling=" + ceiling + ", sunroof=" + sunroof + ", brand=" + brand + "]";
	}
}
