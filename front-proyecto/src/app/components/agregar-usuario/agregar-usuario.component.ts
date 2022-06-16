import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-agregar-usuario',
  templateUrl: './agregar-usuario.component.html',
  styleUrls: ['./agregar-usuario.component.css']
})
export class AgregarUsuarioComponent {
  agregarUsuario: FormGroup;

  constructor(private fb: FormBuilder) { 
    this.agregarUsuario = this.fb.group({
      email_usuario: ['', Validators.required],
      password_usuario: ['', Validators.required],
    })
  }
  agregar(): void{
    console.log(this.agregarUsuario);
  }

}
