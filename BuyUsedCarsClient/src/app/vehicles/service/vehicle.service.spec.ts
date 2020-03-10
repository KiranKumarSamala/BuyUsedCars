import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { environment } from '../../../environments/environment';

import { VehicleService } from './vehicle.service';
import { Vehicle } from 'src/app/model/vehicle';

describe('VehicleService', () => {
  let service: VehicleService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [VehicleService],
    });

    httpTestingController = TestBed.inject(HttpTestingController);
    service = TestBed.inject(VehicleService);
  });

  afterEach(() => {
    httpTestingController.verify();
});

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should be retreive vehicles from API via GET', () => {
    const dummyVehicles: Vehicle[] = [
      {
        "id": 55, "make": "Volvo", "model": "850", "yearModel": 1995,
        "price": 25762.08, "licensed": true, "dateAdded": "2017-10-03"
      },
      {
        "id": 22, "make": "Infiniti", "model": "I", "yearModel": 2002,
        "price": 6910.16, "licensed": false, "dateAdded": "2017-10-15"
      },
      {
        "id": 52, "make": "Porsche", "model": "Cayenne", "yearModel": 2011,
        "price": 17066.31, "licensed": true, "dateAdded": "2017-10-19"
      },
      {
        "id": 71, "make": "Chrysler", "model": "LHS", "yearModel": 2001,
        "price": 29444.71, "licensed": false, "dateAdded": "2017-10-25"
      }
    ];

    service.getVehiclesList().subscribe(vehicleList => {
       expect(vehicleList.length).toBe(4);
    });

    const request = httpTestingController.expectOne(`${environment.baseUrl}/warehouse`);

    expect(request.request.method).toBe('GET');

    request.flush(dummyVehicles);
  });

});
