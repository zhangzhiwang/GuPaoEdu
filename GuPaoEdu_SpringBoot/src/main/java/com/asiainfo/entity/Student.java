package com.asiainfo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
	/***/
	private static final long serialVersionUID = -1445468348499636454L;
	private int id;
	private String name;
	private int gender;
}
