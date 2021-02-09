package com.asiainfo.generic;

import lombok.Data;

@Data
public class ZhangSan<T> {
//	private BMW car = new BMW();// 张三今天开宝马，明天开奔驰，后天开奥迪，这样写死代码要经常修改
//	private Benz car = new Benz();// 张三开什么车不固定，也就是属性car的类型不固定，要想使carded类型固定有两种方案：一个是使用所有车类型的父类或者接口，另一个是将属性car的类型当做一个参数，传进来是什么类型的car就是什么类型，这就是所谓的参数化类型
	
	private T car;
}
