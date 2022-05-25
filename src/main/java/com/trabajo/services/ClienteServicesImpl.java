package com.trabajo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabajo.entidades.Cliente;
import com.trabajo.repository.ClienteRepository;

@Service
public class ClienteServicesImpl implements ClienteService {

	@Autowired
	private ClienteRepository repos;
	
	@Override
	public List<Cliente> listaCliente() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

}
