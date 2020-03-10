import { Component, OnInit } from '@angular/core';
import { VehicleService } from './service/vehicle.service';
import { Vehicle } from '../model/vehicle';

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {

  vehiclesData: Array<Vehicle> = [];

  constructor(private vehicleService: VehicleService) { }

  ngOnInit(): void {

    this.vehicleService.getVehiclesList().subscribe( (resp: any)  => {
      this.vehiclesData = resp;
    });
  }
}
