package com.asiainfo.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.asiainfo.service.api.IOrderService;
import com.asiainfo.service.api.IUserService;

@DubboService(registry = {"beijing"}, protocol = {"protocal_1"})
public class OrderServiceImpl implements IOrderService{
	public String getOrderById(String orderId) {
		return "Order_1";
	}
}
