package com.buycars.warehouse.service;

import java.util.List;

import com.buycars.warehouse.entities.Vehicle;
import com.buycars.warehouse.entities.Warehouse;

public interface WarehouseService {

	/*
	 * This method is used to find all the vehicle list across all warehouse
	 * Sorts by data_added ascending order order
	 */
	public List<Vehicle> findAll();

}
