package com.buycars.warehouse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.buycars.warehouse.repository.WarehouseRepository;

@EnableMongoRepositories(basePackageClasses = WarehouseRepository.class)
@Configuration
public class MongoDBConfig {

}
