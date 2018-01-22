import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders  } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { LoginResponse } from '../entidades/loginResponse';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class LoginService {

  private urlServicioLogin : string = 'https://httpbin.org/post';

  constructor(private http: HttpClient) { 

  }

  /** POST: add a new hero to the server */
  realizarLogin (usuario:String, password:String): Observable<LoginResponse> {
    let mensaje:any  = {"usuario":usuario, "password": password};
    return this.http.post<LoginResponse>(this.urlServicioLogin, mensaje, httpOptions).pipe(
      tap((respuesta:LoginResponse) => this.log(`Login exitoso de ` + usuario)),
      catchError(this.handleError<LoginResponse>('FALLO EN EL LOGIN'))
    );
  }


    /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    console.warn('HeroService: ' + message);
  }
}