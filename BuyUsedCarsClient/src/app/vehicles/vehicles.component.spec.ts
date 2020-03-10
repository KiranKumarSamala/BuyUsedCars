import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { VehiclesComponent } from './vehicles.component';
import { VehicleService } from './service/vehicle.service';
import { Vehicle } from '../model/vehicle';
import { Observable, of } from 'rxjs';

describe('VehiclesComponent', () => {

  let component: VehiclesComponent;
  let fixture: ComponentFixture<VehiclesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [VehiclesComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    TestBed.configureTestingModule({
      // provide the component-under-test and dependent service
      providers: [
        VehiclesComponent,
        { provide: VehicleService, useClass: MockVehicleService }
      ]
    });
    fixture = TestBed.createComponent(VehiclesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();

  });

  it('should create and get list of vehicles', () => {

    const service = TestBed.inject(VehicleService);
    expect(component).toBeTruthy();
    expect(component.vehiclesData.length).toBe(4);
  });
});

class MockVehicleService {
  dummyVehicles: Vehicle[] = [
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

  getVehiclesList(): Observable<Vehicle[]> {
    return of(this.dummyVehicles);
  }
}

