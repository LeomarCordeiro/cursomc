package com.leomaralmeida.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leomaralmeida.cursomc.domain.Pedido;
import com.leomaralmeida.cursomc.repositories.PedidoRepository;
import com.leomaralmeida.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {

		//Optional<Pedido> obj = repo.findById(id);
		//return obj.orElse(null);
		
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}
