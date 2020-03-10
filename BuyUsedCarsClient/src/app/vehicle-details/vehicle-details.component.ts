import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VehicleDetailsService } from './service/vehicle-details.service';
import { Warehouse } from '../model/warehouse';

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.css']
})
export class VehicleDetailsComponent implements OnInit {

  vehicleWarehouse: Warehouse;
  imagesList = ['../../assets/images/audi1.png', '../../assets/images/audi2.png',
    '../../assets/images/audi3.png', '../../assets/images/audi4.png'];
  index = 0;
  enableRightArrow: boolean;
  enableLeftArrow: boolean;

  constructor(private route: ActivatedRoute, private vehicleDetailsService: VehicleDetailsService) {
  }

  ngOnInit(): void {

    this.enableLeftArrow = false;
    this.enableRightArrow = true;

    this.route.paramMap.subscribe(params => {
      const param: any = params.get('id');
      this.getVehicleData(param);
    });

  }

  getVehicleData(id: number) {
    this.vehicleDetailsService.getVehicleData(id).subscribe(resp => {
      this.vehicleWarehouse = resp;
    });
  }

  moveRight() {
    if (this.index !== this.imagesList.length - 1) {
      this.index++;
    }
    this.enableArrows();
  }

  moveLeft() {
    if (this.index !== 0) {
      this.index--;
    }
    this.enableArrows();

  }

  enableArrows() {
    this.enableRightArrow = this.index !== this.imagesList.length - 1;
    this.enableLeftArrow = this.index !== 0;
  }
}
