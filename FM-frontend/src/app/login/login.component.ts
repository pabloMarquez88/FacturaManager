import { Component, OnInit,Input } from '@angular/core';
import { LoginService } from '../services/login.service';
import { Router }  from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

@Input()  usuario :string;
@Input()  password:string;

  constructor(private loginService: LoginService, private router:Router) { }

  ngOnInit() {
  }

  loginUsuario(): void{

    this.loginService.realizarLogin(this.usuario,this.password).subscribe(respuesta =>{
      console.warn(respuesta);
      this.router.navigateByUrl('/home');
    });

  }

  recuperarEvento(): void{
    this.loginService.recuperarEvento().subscribe(respuesta =>console.warn(respuesta));
  }

}
