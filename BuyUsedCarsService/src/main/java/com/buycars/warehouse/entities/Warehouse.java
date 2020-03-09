package com.buycars.warehouse.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Warehouse {

	@Id
	private Long id;

	private String name;

	private Location location;

	private Car cars;
}
