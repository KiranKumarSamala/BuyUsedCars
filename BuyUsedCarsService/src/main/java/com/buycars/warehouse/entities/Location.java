package com.buycars.warehouse.entities;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {

	@Field("lat")
	private String latitude;
	
	@Field("long")
	private String longitude;
}
