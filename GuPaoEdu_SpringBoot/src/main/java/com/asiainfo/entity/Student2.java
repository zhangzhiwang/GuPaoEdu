package com.asiainfo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity// 使用jpa要标注该类是一个实体类
@Table(name = "t_student")// 使用jpa要标注该类所映射的表名称
public class Student2 {
	@Id// 标识该字段是主键
	@GeneratedValue(strategy = GenerationType.IDENTITY)// 主键生成策略
	@Column(name = "id")// 标识该属性映射的表字段名称
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private int gender;
}
