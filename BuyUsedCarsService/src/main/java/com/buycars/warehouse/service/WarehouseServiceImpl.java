package com.buycars.warehouse.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buycars.warehouse.entities.Vehicle;
import com.buycars.warehouse.repository.WarehouseRepositoryImpl;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private WarehouseRepositoryImpl warehouseRepository;

	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public List<Vehicle> findAll() {

		return warehouseRepository.findAll().stream()
				.map(mapper -> mapper.getCars().getVehicles())
				.flatMap(List::stream)
				.sorted(this::compareVehicles)
				.collect(Collectors.toList());

	}

	private int compareVehicles(Vehicle v1, Vehicle v2) {
		LocalDate vehicle1Date = LocalDate.parse(v1.getDateAdded(), dateTimeFormatter);
		LocalDate vehicle2Date = LocalDate.parse(v2.getDateAdded(), dateTimeFormatter);

		return vehicle1Date.compareTo(vehicle2Date);
	}

}
