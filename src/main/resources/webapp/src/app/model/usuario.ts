
export class Usuario{

  nombre: string;

  constructor(_nombre: string){
    this.nombre = _nombre;
  }

  static fromJson(usuarioJson){
    if (usuarioJson == null)
      return new Usuario("");
    return new Usuario(usuarioJson.nombre)
  }
}
