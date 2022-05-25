package com.trabajo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trabajo.entidades.Factura;
import com.trabajo.services.FacturaServices;
import com.trabajo.utils.Constantes;


@RequestMapping("/rest/crudFactura")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CrudFacturaController {
	
	private Logger log = LoggerFactory.getLogger(CrudFacturaController.class);
	
	@Autowired
	private FacturaServices factServ;
	
	@GetMapping("/listaPorFacturaDescLike/{desc}")
	@ResponseBody
	public ResponseEntity<List<Factura>> listarFacturaPorDescLike(@PathVariable("desc") String desc) {
		log.info(" ==> listaPorFacturaDescLike ==> desc : " + desc);
		
		List<Factura> lista = null;
		
		try {
			if(desc.equals("todos")) {
				lista = factServ.listaFactura();
			} else {
				lista = factServ.listaPorDescLike(desc + "%");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(lista);
	}

	@PostMapping("/registrarFacturas")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertarFacturas(@RequestBody Factura obj) {
		
		log.info("==> insertarFacturas ==> COD : " + obj.getCodFac());
		log.info("==> insertarFacturas ==> Descripcion : " + obj.getDescripcion());
		log.info("==> insertarFacturas ==> Fecha : " + obj.getFecha());
		Map<String, Object> salida = new HashMap<>();
		
		try {
			if(obj.getCodFac() != 0) {
				salida.put("mensaje", "El COD de Factura debe ser cero");
				return ResponseEntity.ok(salida);
			}
			List<Factura> lista = null;
			
			lista = factServ.listaPorDesc(obj.getDescripcion());
			if(!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "La Descripcion ya existe : " + obj.getDescripcion());
				return ResponseEntity.ok(salida);
			}
			
			lista = factServ.listaPorFecha(obj.getFecha());
			if(!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "La Fecha ya existe : " + obj.getFecha());
				return ResponseEntity.ok(salida);
			}
			
			Factura objSalida = factServ.insertarActualizarFactura(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			salida.put("mensaje", e);
		}
		return ResponseEntity.ok(salida);
		
	}
	
	
	@PutMapping("/actualizaFactura")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizarFactura(@RequestBody Factura obj) {
		log.info("==> insertarFacturas ==> COD : " + obj.getCodFac());
		log.info("==> insertarFacturas ==> Descripcion : " + obj.getDescripcion());
		log.info("==> insertarFacturas ==> Fecha : " + obj.getFecha());
		Map<String, Object> salida = new HashMap<>();
		
		try {
			if(obj.getCodFac() == 0) {
				salida.put("mensaje", "El COD del Factura debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			
			Factura objSalida = factServ.insertarActualizarFactura(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		
		return ResponseEntity.ok(salida);
		
	}
	
	
}
