import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams  } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { LoginResponse } from '../entidades/loginResponse';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class LoginService {

  private urlServicioLogin : string = 'http://localhost:8080/login';

  constructor(private http: HttpClient) { 

  }

  /** POST: add a new hero to the server */
  recuperarEvento (): Observable<any> {
    return this.http.get('http://localhost:8080/list',{ withCredentials: true });
  }


  /** POST: add a new hero to the server */
  realizarLogin (usuario:string, password:string): Observable<any> {
    let encabezado : any = new HttpHeaders()
        .set('Content-Type', 'application/x-www-form-urlencoded');

    let body : any = new HttpParams()
      .set('username', usuario)
      .set('password', password);
    return this.http.post(this.urlServicioLogin,
      body.toString(),
      
      {
        headers: encabezado,withCredentials:true
      }
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