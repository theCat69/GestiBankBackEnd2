package com.wha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.model.Client;
import com.wha.service.ServiceClient;

@RestController
public class ClientRestController {
	
	@Autowired
	private ServiceClient serviceClient;

	public ClientRestController() {
	}

	@GetMapping("/clients")
	public List<Client> getClients() {
		return serviceClient.findAllClients();
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id") int id) {

		Client client = serviceClient.findById(id);

		if (null == client) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		else {
		return new ResponseEntity<Client>(client, HttpStatus.OK);}
	}
	
	@PostMapping(value = "/clients")
	@Transactional
	public ResponseEntity<Client> createCustomer(@RequestBody Client client){
		
		serviceClient.saveClient(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	@DeleteMapping("/clients/{id}")
	@Transactional
	public ResponseEntity<Integer> deleteClient(@PathVariable("id") int id) {

		serviceClient.deleteClientById(id);
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}
	
	@DeleteMapping("/clients/deleteallclients")
	@Transactional
	public ResponseEntity<String> deleteAllClient() {
		serviceClient.deleteAllClients();
		return new ResponseEntity<String>("all Clients deleted", HttpStatus.OK);
	}
	
	@PutMapping("/clients/{id}")
	@Transactional
	public ResponseEntity<Client> updateClient(@PathVariable("id") int id, @RequestBody Client client) {
		serviceClient.updateClientById(id, client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	
	}
}
