package com.buycars.warehouse.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.buycars.warehouse.entities.Car;
import com.buycars.warehouse.entities.Location;
import com.buycars.warehouse.entities.Vehicle;
import com.buycars.warehouse.entities.Warehouse;
import com.buycars.warehouse.repository.WarehouseRepositoryImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class WarehouseServiceImplTest {

	
	@MockBean
	private WarehouseRepositoryImpl warehouseRepositoryImpl;
	
	@Autowired
	private WarehouseService warehouseService;
	
	private static List<Warehouse> warehouseList = new ArrayList<Warehouse>();
	private static Warehouse warehouse;
	
    public List<Warehouse> getWareHouseList() {
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
		
		warehouseList.add(warehouse1);
		warehouseList.add(warehouse2);

		return warehouseList;
	}
	
	@Test
	void testFindAll() {
		when(warehouseRepositoryImpl.findAll()).thenReturn(getWareHouseList());
		List<Vehicle> vehicleList = warehouseService.findAll();
		
		assertTrue(vehicleList.size() == 4);
		assertTrue(vehicleList.get(0).getId() == 4);
		assertTrue(vehicleList.get(3).getId() == 3);

	}

	@Test
	void testFindWarehouseByVehicle() {
		when(warehouseRepositoryImpl.findWarehouseByVehicle(1L)).thenReturn(getWareHouse());
		Warehouse warehouseValue = warehouseService.findWarehouseByVehicle(1L);
		
		assertTrue(warehouseValue.getId() == 1);
		assertTrue(warehouseValue.getCars().getVehicles().size() == 1);
		assertTrue(warehouseValue.getCars().getVehicles().get(0).getId() == 1L);

	}
	   public Warehouse getWareHouse() {
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

	 		Car car1 = new Car();
	 		car1.setLocationName("West wing");
	 		car1.setVehicles(new ArrayList<>());
	 		
	 		car1.getVehicles().add(v1);
	 		car1.getVehicles().add(v2);
	 		
	 		Location location1 = new Location();
	 		location1.setLatitude("47.13111");
	 		location1.setLongitude("-61.54801");
	 		return new Warehouse(1L, "Warehouse A", location1, car1);

	 	}
}
