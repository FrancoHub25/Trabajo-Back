package com.trabajo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codClie;
	private String nomApeClie;
	private String direccion;
	
	
	public int getCodClie() {
		return codClie;
	}
	public void setCodClie(int codClie) {
		this.codClie = codClie;
	}
	public String getNomApeClie() {
		return nomApeClie;
	}
	public void setNomApeClie(String nomApeClie) {
		this.nomApeClie = nomApeClie;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	
	
}
