import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Usuario } from './interfaces/usuario';
import {HttpClientModule} from '@angular/common/http';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // title = 'front-proyecto';
  agregarUsuario: FormGroup;
  constructor(private fb: FormBuilder) { 
    this.agregarUsuario = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
    })
  }
  agregar() {
    console.log(this.agregarUsuario);

    const usuario: Usuario = {
      email: this.agregarUsuario.get('email')?.value,

      password: this.agregarUsuario.get('password')?.value
    }
    console.log(usuario);
  }
}
