
import {Usuario} from "../model/usuario";
import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import 'rxjs/add/operator/map';

@Injectable()
export class UsuariosService{

  constructor(private http: Http){}

  usuariosPosibles(){
    return this.http.get("/usuarios").map(this.extractData)
  }

  private extractData(res: Response){
    let body = res.json();
    let usuarios = [];
    body.forEach(usuarioJSON => usuarios.push(
      Usuario.fromJson(usuarioJSON)
    ));
    return usuarios;
  }
}
