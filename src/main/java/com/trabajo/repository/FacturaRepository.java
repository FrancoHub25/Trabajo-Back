package com.trabajo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trabajo.entidades.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
	
	@Query("Select f from Factura f where descripcion like :fil")
	public abstract List<Factura> listaFacturaPorDesc(@Param("fil") String filtro);
	
	
	public List<Factura> findByDescripcionLike(String descripcion);
	public List<Factura> findByDesc(String descripcion);
	public List<Factura> findByFecha(Date fecha);

}
