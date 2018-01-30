import { Component, OnInit } from '@angular/core';
import { EventoService } from '../services/evento.service';
import { Evento } from '../entidades/evento';
import { Persona } from '../entidades/persona';
import { LoginService } from '../services/login.service';
import { RequestFM } from '../entidades/requestFM';
import { Router }  from '@angular/router';

@Component({
  selector: 'app-vota',
  templateUrl: './vota.component.html',
  styleUrls: ['./vota.component.css']
})
export class VotaComponent implements OnInit {

  eventoActual: Evento;
  candidatos: Persona[] = new Array();

  personaCandidata: Persona;

  resultado: string;

  constructor(private eventoService: EventoService, private loginService: LoginService, private router:Router) { }

  ngOnInit() {
    if (!this.loginService.usuario.nombre){
      this.router.navigateByUrl('/login');
    }
    this.cargarEvento();
  }

  cargarEvento(): void {
    this.eventoService.getEventoSemana().subscribe(salida => {
      this.eventoActual = salida;
      this.candidatos.push(this.eventoActual.persona1);
      this.candidatos.push(this.eventoActual.persona2);
    });

  }

  votarPersona(): void {
    console.warn(this.personaCandidata);
    console.warn(this.loginService.usuario);
    console.warn(this.eventoActual);
    this.eventoService.votar(this.personaCandidata, this.loginService.usuario, this.eventoActual)
      .subscribe(requestFM => this.procesarRespuesta(requestFM),
      requestFM => this.procesarRespuesta(requestFM));

  }

  procesarRespuesta(requestFm: any): void {
    if (requestFm.resultado) {
      this.resultado = requestFm.resultado;
    } else {
      this.resultado = requestFm.error.resultado;
    }
  }

}
