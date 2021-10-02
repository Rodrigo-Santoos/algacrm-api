package com.algaworks.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.crm.model.Cliente;
import com.algaworks.crm.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//restcontroller é um controlador rest, estamos dizendo que essa classe vai receber requisiçoes
@RestController

//requestmapping mapeia os end-points para receber requisiçoes ex:localhost:8080-->/clientes
//quando chegar na requisiçoes /clientes ele vai cair nessa classe
@RequestMapping(value ="/clientes")
@Api(value="API REST de Pacientes")
@CrossOrigin(origins="*")
public class ClienteController {

	//metodo
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	//Toda vez que a requisiçao usando o verbo http get na uri(/clientes)
	//esse metodo que vai responder essa requisiçao
	@GetMapping
	@ApiOperation(value="Trazer todos os Clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Trazer unico cliente")
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
