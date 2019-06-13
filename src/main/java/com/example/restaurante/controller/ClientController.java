package com.example.restaurante.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurante.dto.ClientDTO;
import com.example.restaurante.service.ClientService;

@RestController
@RequestMapping(value = "restaurant_api")
public class ClientController {
	public ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping(value = "/restaurant")
	public ResponseEntity<List<ClientDTO>> obtainClient() {
		List<ClientDTO> clients = clientService.findAll();
		return new ResponseEntity<List<ClientDTO>>(clients, HttpStatus.OK);
	}
	
	@PostMapping(value = "/restaurant")
	public ResponseEntity<?> save(@RequestBody @Valid ClientDTO clientDTO){
		this.clientService.save(clientDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/restaurant/{cpf}")
	public ResponseEntity<?>delete(@PathVariable("cpf") String cpf){
		this.clientService.deleteByCpf(cpf);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
