import { Component, OnInit } from '@angular/core';
//import { Usuario } from './interfaces/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';
@Component({
  selector: 'app-ver-usuario',
  templateUrl: './ver-usuario.component.html',
  styleUrls: ['./ver-usuario.component.css']
})
export class VerUsuarioComponent implements OnInit {

  constructor(private _usuarioService: UsuarioService) { }
  ngOnInit(): void {
      this.getUsuarios();
  }
  getUsuarios(){
    this._usuarioService.getListUsers().subscribe(data =>{
      console.log(data);
    },error => {
      console.log(error)
    })
  }
}
