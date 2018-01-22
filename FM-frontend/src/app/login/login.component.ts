import { Component, OnInit,Input } from '@angular/core';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

@Input()  usuario :string;
@Input()  password:string;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  loginUsuario(): void{
    this.loginService.realizarLogin(this.usuario,this.password).subscribe(respuesta =>console.warn(respuesta));
  }

}
