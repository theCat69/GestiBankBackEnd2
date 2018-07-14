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
import com.wha.model.Conseiller;

import com.wha.service.ServiceClient;
import com.wha.service.ServiceConseiller;

@RestController
public class ConseillerRestController {
	
	@Autowired
	private ServiceConseiller serviceConseiller;
	@Autowired
	private ServiceClient serviceClient;

	public ConseillerRestController() {
	}

	@GetMapping("/conseillers")
	public List<Conseiller> getConseillers() {
		return serviceConseiller.findAllConseillers();
	}

	@GetMapping("/conseillers/{id}")
	public ResponseEntity<Conseiller> getConseiller(@PathVariable("id") int id) {

		Conseiller conseiller = serviceConseiller.findById(id);

		if (conseiller == null) {
			return new ResponseEntity<Conseiller>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Conseiller>(conseiller, HttpStatus.OK);
	}
	
	@GetMapping("/conseillers/{id}/clients")
	public ResponseEntity<List<Client>> getClientsByConseiller(@PathVariable("id") int id) {
		List<Client> clients = serviceConseiller.findById(id).getClients();
		if(clients == null) {
			return new ResponseEntity<List<Client>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}

	@PostMapping(value = "/conseillers")
	@Transactional
	public ResponseEntity<Conseiller> createConseiller(@RequestBody Conseiller conseiller) {

		serviceConseiller.save(conseiller);
		return new ResponseEntity<Conseiller>(conseiller, HttpStatus.OK);
	}

	@DeleteMapping("/conseillers/{id}")
	@Transactional
	public ResponseEntity<Integer> deleteConseiller(@PathVariable Integer id) {
		if (serviceConseiller.findById(id) == null) {
			return new ResponseEntity<Integer>(id, HttpStatus.NOT_FOUND);
		} else {
			serviceConseiller.deleteConseillerById(id);
			return new ResponseEntity<Integer>(id, HttpStatus.OK);
		}	
	}

	@PutMapping("/conseillers/{id}")
	@Transactional
	public ResponseEntity<Boolean> updateConseiller(@PathVariable Integer id, @RequestBody Conseiller conseiller) {

		if (serviceConseiller.findById(id) == null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		} else {
			serviceConseiller.updateConseillerById(id, conseiller);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
	}
	
	@PutMapping(value = "/conseillers/clients/{id}")
	@Transactional
	public ResponseEntity<Client> attribuerClient(@PathVariable("id") int id, @RequestBody Conseiller conseiller) {
		
		int idCons = conseiller.getId();

		Conseiller trueConseiller = serviceConseiller.findById(idCons);
		Client client = serviceClient.findById(id);
		
		trueConseiller.getClients().add(client);
		serviceConseiller.updateConseiller(trueConseiller);
		
		client.setIdConseiller(idCons);
		serviceClient.updateClient(client);
		
		if (trueConseiller == null || client == null) {
			return new ResponseEntity<Client>(client, HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		}
	}
  
}
