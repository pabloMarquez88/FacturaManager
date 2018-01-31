import { Component, OnInit, Input } from '@angular/core';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';
import { Persona } from '../entidades/persona';
import { IntercomunicacionService } from '../services/intercomunicacion.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @Input() usuario: string;
  @Input() password: string;

  constructor(private loginService: LoginService, private router: Router, private comunicacionService : IntercomunicacionService) { }

  ngOnInit() {
  }

  loginUsuario(): void {

    this.loginService.realizarLogin(this.usuario, this.password).subscribe(respuesta => {
      console.warn(respuesta);
      let per: Persona = new Persona();
      per.nombre = respuesta.usuario;
      this.loginService.guardarUsuario(per);
      this.comunicacionService.updateData(true);
      this.router.navigateByUrl('/home');
    });

  }

  recuperarEvento(): void {
    this.loginService.recuperarEvento().subscribe(respuesta => console.warn(respuesta));
  }

}
