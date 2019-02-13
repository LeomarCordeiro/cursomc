package com.leomaralmeida.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leomaralmeida.cursomc.domain.Cliente;
import com.leomaralmeida.cursomc.repositories.ClienteRepository;
import com.leomaralmeida.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {

		//Optional<Cliente> obj = repo.findById(id);
		//return obj.orElse(null);
		
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
