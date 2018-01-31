import { TestBed, inject } from '@angular/core/testing';

import { IntercomunicacionService } from './intercomunicacion.service';

describe('IntercomunicacionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [IntercomunicacionService]
    });
  });

  it('should be created', inject([IntercomunicacionService], (service: IntercomunicacionService) => {
    expect(service).toBeTruthy();
  }));
});
