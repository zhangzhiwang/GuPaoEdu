package com.asiainfo.service;

import org.springframework.stereotype.Service;

import com.asiainfo.api.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Override
	public String getProductById() {
		return "Apple";
	}

}
