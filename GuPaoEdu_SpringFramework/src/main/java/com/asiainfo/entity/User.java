package com.asiainfo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("用户实体类")// 用于swagger页面中显示对实体类的说明
public class User {
	@ApiModelProperty("主键")// 用于swagger页面中显示对类属性的说明
	private int id;
	@ApiModelProperty("姓名")
	private String name;
	private int age;
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}
