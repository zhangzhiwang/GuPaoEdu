package com.asiainfo.entity;

import java.util.List;

import lombok.Data;

@Data
public class Teacher {
	private int tId;
	private String tName;
	private List<TClass> tClassList;
}
