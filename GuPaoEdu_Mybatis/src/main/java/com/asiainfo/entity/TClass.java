package com.asiainfo.entity;

import java.util.List;

import lombok.Data;

@Data
public class TClass {
	private int cId;
	private String cName;
	private List<Teacher> teacherList;
}
