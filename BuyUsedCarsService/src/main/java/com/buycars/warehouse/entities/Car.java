package com.buycars.warehouse.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {

	@Field("location")
	private String locationName;
	
	private List<Vehicle> vehicles;
}
