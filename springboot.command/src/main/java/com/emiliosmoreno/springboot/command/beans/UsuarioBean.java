package com.emiliosmoreno.springboot.command.beans;

public class UsuarioBean {

	private Long id;
	private String nombre;
	private String apellidos;
	private String dni;
	
	public UsuarioBean( String nombre, String apellidos, String dni) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.dni=dni;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
