package com.buycars.warehouse.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.buycars.warehouse.entities.Warehouse;

public interface WarehouseRepository extends MongoRepository<Warehouse, Long> {

}
