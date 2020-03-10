import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Vehicle } from 'src/app/model/vehicle';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  getVehiclesList(): Observable<Array<Vehicle>> {
    const url = this.baseUrl + '/warehouse';
    return this.http.get<Array<Vehicle>>(url);
  }
}
