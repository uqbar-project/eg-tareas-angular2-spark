package ar.edu.tareas.domain;

import java.util.Date;

import org.uqbar.commons.model.Entity;

import ar.edu.tareas.errors.BusinessException;

public class Tarea extends Entity {
	private static final int TAREA_COMPLETA = 100;

	private String descripcion;
	private String iteracion;
	private int porcentajeCumplimiento;
	private Usuario asignatario;
	private Date fecha;

	public Tarea() {
		this.initialize();
	}

	public Tarea(String descripcion, Date fecha) {
		this.initialize();
		this.descripcion = descripcion;
		this.fecha = fecha;
	}

	public void initialize() {
		this.descripcion = "";
		this.iteracion = "";
		this.fecha = new Date();
		this.porcentajeCumplimiento = 0;
	}

	public void validar() {
		if (this.descripcion.equals("")) {
			throw new BusinessException("Debe ingresar descripcion");
		}
		if (this.fecha == null) {
			throw new BusinessException("Debe ingresar fecha");
		}
	}

	public boolean estaCumplida() {
		return this.porcentajeCumplimiento == TAREA_COMPLETA;
	}

	public boolean estaPendiente() {
		return !this.estaCumplida();
	}

	@Override
	public String toString() {
		return this.descripcion;
	}

	public void asignarA(Usuario usuario) {
		this.asignatario = usuario;
	}
	
	@Override
	public boolean equals(Object o) {
		try {
			Tarea otra = (Tarea)o;
			return otra.getId().equals(this.getId());
		} catch (ClassCastException e) {
			return false;
		}
	}	

	@Override 
	public int hashCode() {
		return this.getId().hashCode();
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIteracion() {
		return this.iteracion;
	}

	public void setIteracion(String iteracion) {
		this.iteracion = iteracion;
	}

	public int getPorcentajeCumplimiento() {
		return this.porcentajeCumplimiento;
	}

	public void setPorcentajeCumplimiento(int porcentajeCumplimiento) {
		this.porcentajeCumplimiento = porcentajeCumplimiento;
	}

	public Usuario getAsignatario() {
		return this.asignatario;
	}

	public void setAsignatario(Usuario asignatario) {
		this.asignatario = asignatario;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
