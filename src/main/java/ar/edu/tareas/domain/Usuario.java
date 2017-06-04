package ar.edu.tareas.domain;

import org.uqbar.commons.model.Entity;

public class Usuario extends Entity {

	private String nombre;

	public Usuario() {
	}

	public Usuario(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
