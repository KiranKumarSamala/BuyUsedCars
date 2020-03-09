package com.buycars.warehouse.entities;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {

	@Field("_id")
	private Long id;
	private String make;
	private String model;
	
	@Field("year_model")
	private Integer yearModel;
	
	private Double price;
	private boolean licensed;
	
	@Field("date_added")
	private String dateAdded;
	
}
