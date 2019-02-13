package com.leomaralmeida.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leomaralmeida.cursomc.domain.Cliente;
import com.leomaralmeida.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	/*
	 * public List<Cliente> listar () { Cliente cat1 = new Cliente(1,
	 * "Informatica"); Cliente cat2 = new Cliente(2, "Escritorio");
	 * 
	 * //list é interface List <Cliente> lista = new ArrayList<>();
	 * lista.add(cat1); lista.add(cat2);
	 * 
	 * return lista; }
	 */

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
		// sem try cath
		
		

	}

}
