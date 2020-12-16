package com.asiainfo.entity;

import lombok.Data;

@Data
public class Product {
	private int productId;
	private String productName;
	
	public Product() {
		System.out.println("Product无参构造器");
	}
}
