import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleDetailsComponent } from './vehicle-details.component';
import { VehicleDetailsService } from './service/vehicle-details.service';
import { Warehouse } from '../model/warehouse';
import { Observable, of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

describe('VehicleDetailsComponent', () => {
  let component: VehicleDetailsComponent;
  let fixture: ComponentFixture<VehicleDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [VehicleDetailsComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    TestBed.configureTestingModule({
      // provide the component-under-test and dependent service
      providers: [
        VehicleDetailsComponent,
        { provide: VehicleDetailsService, useClass: MockVehicleDetailsService },
        { provide: ActivatedRoute, useClass: MockActivatedRoute }
      ]
    });

    fixture = TestBed.createComponent(VehicleDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create and get the vehicle details ', () => {
    expect(component).toBeTruthy();
  });
});


class MockVehicleDetailsService {
  jsonData = {
    "id": "3",
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

  getVehicleData(): Observable<Warehouse> {
    const dummyVehicles = new Warehouse();
    Object.assign(dummyVehicles, this.jsonData);
    return of(dummyVehicles);
  }
}

class MockActivatedRoute {
  paramMap = of({ get: (id) => 55 });
}