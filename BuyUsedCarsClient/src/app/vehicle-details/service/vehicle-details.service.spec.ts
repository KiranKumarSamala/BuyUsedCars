import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { VehicleDetailsService } from './vehicle-details.service';
import { Warehouse } from 'src/app/model/warehouse';
import { environment } from 'src/environments/environment';

describe('VehicleDetailsService', () => {
  let service: VehicleDetailsService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [VehicleDetailsService],
    });

    httpTestingController = TestBed.inject(HttpTestingController);
    service = TestBed.inject(VehicleDetailsService);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should be retreive vehicles details from API via GET', () => {
    const dummyVehicles = new Warehouse();
    const jsonData = {
      "id": 3,
      "name": "Warehouse C",
      "location": { "latitude": "39.12788", "longitude": "-2.71398" },
      "cars": {
        "locationName": "Suid wing",
        "vehicles": [
          {
            "id": 55, "make": "Volvo", "model": "850", "yearModel": 1995,
            "price": 25762.08, "licensed": true, "dateAdded": "2017-10-03"
          }
        ]
      }
    };
    Object.assign(dummyVehicles, jsonData);

    service.getVehicleData(55).subscribe(warehouse => {
       expect(warehouse.id).toBe(3);
    });

    const request = httpTestingController.expectOne(`${environment.baseUrl}/warehouse/vehicle?vehicleId=55`);

    expect(request.request.method).toBe('GET');

    request.flush(dummyVehicles);
  });

});

