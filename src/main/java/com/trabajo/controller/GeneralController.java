package com.trabajo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trabajo.entidades.Cliente;
import com.trabajo.services.ClienteService;

@RestController
@RequestMapping("/url/listas")
@CrossOrigin(origins = "http://localhost:4200")
public class GeneralController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listaCli")
	@ResponseBody
	public List<Cliente> listaCliente() {
		return clienteService.listaCliente();
	}
	
}
