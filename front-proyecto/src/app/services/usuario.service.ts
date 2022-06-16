import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private myAppUrl = 'https://localhost:44318/';
  private myApiUrl = 'api/users/'
  constructor(private http: HttpClient) { }
  getListUsers(): Observable<any>{
    return this.http.get(this.myAppUrl + this.myApiUrl);
  }
}
