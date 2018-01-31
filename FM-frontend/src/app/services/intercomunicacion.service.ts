import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class IntercomunicacionService {

  private dataObs$ = new Subject();

  getData() {
      return this.dataObs$;
  }

  updateData(data: boolean) {
      this.dataObs$.next(data);
  }

  constructor() { }


}
