package com.buycars.warehouse.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.buycars.warehouse.entities.Warehouse;

@Repository
public class WarehouseRepositoryImpl {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Warehouse> findAll(){
		return mongoTemplate.findAll(Warehouse.class);
	}
	
	public Warehouse findWarehouseByVehicle(Long vehicleId) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("cars.vehicles.id").is(vehicleId));
		return mongoTemplate.findOne(query, Warehouse.class);
	}
}
