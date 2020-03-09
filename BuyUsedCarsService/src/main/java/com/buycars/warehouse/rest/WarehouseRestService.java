package com.buycars.warehouse.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buycars.warehouse.entities.Vehicle;
import com.buycars.warehouse.service.WarehouseService;

@CrossOrigin
@RestController
public class WarehouseRestService {

	@Autowired
	private WarehouseService warehouseService;
	
	/*
	 * This method is used to find all the vehicle list across all warehouse
	 * Sorts by data_added ascending order order
	 */
	@GetMapping(path = "/warehouse")
	public List<Vehicle> findAll(){
		return warehouseService.findAll();
	}

}
