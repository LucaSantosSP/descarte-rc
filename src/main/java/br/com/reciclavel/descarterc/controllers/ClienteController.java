package br.com.reciclavel.descarterc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.reciclavel.descarterc.models.ClienteObj;

@RestController
@RequestMapping(path="/clientes")
public class ClienteController {

	@GetMapping(path="/qualquer")
	public ClienteObj obterCliente() {
		return new ClienteObj(28, "Pedro", "123.456.789-00");
	}
	
	@GetMapping("/{id}")
	public ClienteObj obterClientePorId(@PathVariable int id) {
		return new ClienteObj(id, "Maria", "987.654.321-00");
	}
	
	@GetMapping
	public ClienteObj obeterClientePorId2 (@RequestParam(name="id") int id) {
		return new ClienteObj(id, "João Augusto", "111.222.333-44");
	}
}
