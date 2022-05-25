package com.trabajo.services;

import java.util.Date;
import java.util.List;

import com.trabajo.entidades.Factura;

public interface FacturaServices {

	public abstract List<Factura> listaFactura();
	
	public abstract Factura insertarActualizarFactura(Factura obj);
	
	public abstract List<Factura> listaPorDescLike(String descripcion);
	public abstract List<Factura> listaPorDesc(String descripcion);
	public abstract List<Factura> listaPorFecha(Date fecha);
	
	
}
