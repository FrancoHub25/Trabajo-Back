package com.trabajo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabajo.entidades.Factura;
import com.trabajo.repository.FacturaRepository;

@Service
public class FacturaServicesImpl implements FacturaServices {

	@Autowired
	private FacturaRepository repo;
	
	@Override
	public List<Factura> listaFactura() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Factura insertarActualizarFactura(Factura obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Factura> listaPorDescLike(String descripcion) {
		// TODO Auto-generated method stub
		return repo.findByDescripcionLike(descripcion);
	}

	@Override
	public List<Factura> listaPorFecha(Date fecha) {
		// TODO Auto-generated method stub
		return repo.findByFecha(fecha);
	}

	@Override
	public List<Factura> listaPorDesc(String descripcion) {
		// TODO Auto-generated method stub
		return repo.findByDesc(descripcion);
	}

}
