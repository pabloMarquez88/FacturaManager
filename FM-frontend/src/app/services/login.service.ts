import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { LoginResponse } from '../entidades/loginResponse';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import { Persona } from '../entidades/persona';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class LoginService {

public usuario : Persona = new Persona();

  private urlServicio: string = 'http://soft016g:8080/';

  constructor(private http: HttpClient) {

  }

  /** POST: add a new hero to the server */
  recuperarEvento(): Observable<any> {
    return this.http.get(this.urlServicio+'list', { withCredentials: true });
  }


  /** POST: add a new hero to the server */
  realizarLogin(usuario: string, password: string): Observable<any> {
    let encabezado: any = new HttpHeaders()
      .set('Content-Type', 'application/x-www-form-urlencoded');

    let body: any = new HttpParams()
      .set('username', usuario)
      .set('password', password);
    return this.http.post(this.urlServicio+'login',
      body.toString(),

      {
        headers: encabezado, withCredentials: true
      }
    );
  }

  guardarUsuario(personaL : Persona): void{
    this.usuario.nombre = personaL.nombre;
  }


  /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
  private handleError<T>(operation = 'operation', result?: T) {
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