import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../../environments/environment';
import { Warehouse } from 'src/app/model/warehouse';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehicleDetailsService {

  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  getVehicleData(id: number): Observable<Warehouse> {

    const url = this.baseUrl + '/warehouse/vehicle?vehicleId=' + id;
    return this.http.get<Warehouse>(url);
  }
}
