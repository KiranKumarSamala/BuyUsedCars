package com.buycars.warehouse.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.buycars.warehouse.entities.Car;
import com.buycars.warehouse.entities.Location;
import com.buycars.warehouse.entities.Vehicle;
import com.buycars.warehouse.entities.Warehouse;

@ExtendWith(SpringExtension.class)
@DataMongoTest
@ActiveProfiles("test")
class WarehouseRepositoryImplTest {
	
	@Autowired
	private WarehouseRepositoryImpl warehouseRepositoryImpl;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@BeforeEach
    public void dataSetup() {
		Vehicle v1 = new Vehicle();
		v1.setId(1L);
		v1.setLicensed(true);
		v1.setMake("Volkswagen");
		v1.setModel("Volkswagen");
		v1.setYearModel(1995);
		v1.setPrice(12947.52);
		v1.setDateAdded("2018-09-18");
		
		Vehicle v2= new Vehicle();
		v2.setId(2L);
		v2.setDateAdded("2018-09-15");

		Vehicle v3= new Vehicle();
		v3.setId(3L);
		v3.setDateAdded("2018-10-01");
		
		Vehicle v4= new Vehicle();
		v4.setId(4L);
		v4.setDateAdded("2018-01-01");
		
		Car car1 = new Car();
		car1.setLocationName("West wing");
		car1.setVehicles(new ArrayList<>());
		
		car1.getVehicles().add(v1);
		car1.getVehicles().add(v2);
		
		Location location1 = new Location();
		location1.setLatitude("47.13111");
		location1.setLongitude("-61.54801");
		Warehouse warehouse1 = new Warehouse(1L, "Warehouse A", location1, car1);
		
		
		Car car2 = new Car();
		car2.setLocationName("East wing");
		car2.setVehicles(new ArrayList<>());
		
		car2.getVehicles().add(v3);
		car2.getVehicles().add(v4);
		Location location2 = new Location();
		location2.setLatitude("15.95386");
		location2.setLongitude("7.06246");
		Warehouse warehouse2 = new Warehouse(2L, "Warehouse B", location2, car2);
		
		warehouseRepository.save(warehouse1);
		warehouseRepository.save(warehouse2);

	}

	@Test
	void testFindAll() {
		List<Warehouse> warehouseList = warehouseRepositoryImpl.findAll();
		
		assertTrue(warehouseList.size() == 2);
	}

	@Test
	void testFindWarehouseByVehicle() {
		
		Warehouse w1 = warehouseRepositoryImpl.findWarehouseByVehicle(4L);
		
		assertTrue(w1.getName().equals("Warehouse B"));
		assertTrue( w1.getLocation().getLatitude().equals("15.95386"));
		assertTrue( w1.getLocation().getLongitude().equals("7.06246"));
		
		assertTrue( w1.getCars().getLocationName().equals("East wing"));
		
		List<Vehicle> vehicle = w1.getCars().getVehicles();
		assertTrue(vehicle.size() == 2);
		
		assertTrue(vehicle.get(1).getId() == 4);

	}
}
