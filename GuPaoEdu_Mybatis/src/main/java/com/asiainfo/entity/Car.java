package com.asiainfo.entity;

import java.util.List;

import lombok.Data;

@Data
public class Car {
	private int carId;
	private String carName;
	private List<Seat> seatList;
}
