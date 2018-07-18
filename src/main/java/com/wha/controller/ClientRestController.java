package com.wha.controller;

import java.util.ArrayList;
import java.util.Set;

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
import com.wha.model.Compte;
import com.wha.model.DemandeOuvertureCompte;
import com.wha.service.ServiceClient;

@RestController
public class ClientRestController {

	@Autowired
	private ServiceClient serviceClient;

	public ClientRestController() {
	}

	@GetMapping("/clients")
	public ResponseEntity<ArrayList<Client>> getClients() {
		ArrayList<Client> clients = serviceClient.findAllClients();
		if (clients == null) {
			return new ResponseEntity<ArrayList<Client>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<ArrayList<Client>>(clients, HttpStatus.OK);
		}

	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id") int id) {

		Client client = serviceClient.findById(id);

		if (null == client) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		}
	}

	@GetMapping("/clients/nbnotattributed")
	public ResponseEntity<Long> getNbOfNotAttributedClient() {
		Long nb = serviceClient.findNbOfNotAttClients();
		return new ResponseEntity<Long>(nb, HttpStatus.OK);
	}

	@GetMapping("clients/notAttributed")
	public ResponseEntity<ArrayList<Client>> getClientsNotAttributed() {
		ArrayList<Client> clients = serviceClient.findClientsNotAttributed();
		if (clients == null) {
			return new ResponseEntity<ArrayList<Client>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<ArrayList<Client>>(clients, HttpStatus.OK);
		}

	}

	@PostMapping(value = "/clients")
	@Transactional
	public ResponseEntity<Client> createCustomer(@RequestBody Client client) {
		serviceClient.saveClient(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	@DeleteMapping("/clients/{id}")
	@Transactional
	public ResponseEntity<Integer> deleteClient(@PathVariable("id") int id) {
		if (serviceClient.findById(id) == null) {
			return new ResponseEntity<Integer>(id, HttpStatus.NOT_FOUND);
		} else {
			serviceClient.deleteClientById(id);
			return new ResponseEntity<Integer>(id, HttpStatus.OK);
		}
	}

	// For dev fun :p
	@DeleteMapping("/clients/deleteallclients")
	@Transactional
	public ResponseEntity<String> deleteAllClient() {
		serviceClient.deleteAllClients();
		return new ResponseEntity<String>("all Clients deleted", HttpStatus.OK);
	}

	@PutMapping("/clients/{id}")
	@Transactional
	public ResponseEntity<Boolean> updateClient(@PathVariable("id") int id, @RequestBody Client client) {
		if (serviceClient.findById(id) == null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		} else {
			serviceClient.updateClientById(id, client);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
	}

	@GetMapping("/clients/{id}/comptes")
	public Set<Compte> getComptes(@PathVariable("id") int id) {
		Client client = serviceClient.findById(id);
		return client.getComptes();
	}

	@GetMapping("/clients/{id}/comptesRorC/{description}")
	public ResponseEntity<Set<Compte>> getComptesCourantRemenuere(@PathVariable("id") int id,
			@PathVariable("description") String description) {
		Set<Compte> comptes = serviceClient.getCompteCourantRemenuere(description, id);
		if (comptes == null) {
			return new ResponseEntity<Set<Compte>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Set<Compte>>(comptes, HttpStatus.OK);
		}
	}

	@PutMapping("/clients/{id}/comptes")
	@Transactional
	public ResponseEntity<Client> createCompte(@PathVariable("id") int id, @RequestBody Compte compte) {
		Client client = serviceClient.findById(id);
		if (client == null) {
			return new ResponseEntity<Client>(client, HttpStatus.NOT_FOUND);
		} else {
			if (compte == null) {
				return new ResponseEntity<Client>(client, HttpStatus.NO_CONTENT);
			} else {
				client.getComptes().add(compte);
				serviceClient.updateClient(client);
				System.out.println(client);
				return new ResponseEntity<Client>(client, HttpStatus.OK);
			}
		}

	}

	@DeleteMapping("/clients/{id}/comptes")
	@Transactional
	public ResponseEntity<Client> deleteCompte(@PathVariable("id") int id, @RequestBody Compte compte) {
		Client client = serviceClient.findById(id);
		if (client == null) {
			return new ResponseEntity<Client>(client, HttpStatus.NOT_FOUND);
		} else {
			if (compte == null) {
				return new ResponseEntity<Client>(client, HttpStatus.NO_CONTENT);
			} else {
				client.getComptes().remove(compte);
				serviceClient.updateClient(client);
				System.out.println(client);
				return new ResponseEntity<Client>(client, HttpStatus.OK);
			}
		}

	}

	@PostMapping(value = "/clients/DOCpts")
	@Transactional
	public ResponseEntity<Boolean> demandeOuvertureCompte(@RequestBody DemandeOuvertureCompte dOC) {
		try {
			serviceClient.demandeOuvertureCompte(dOC);
			if (dOC == null) {
				return new ResponseEntity<Boolean>(false, HttpStatus.NOT_MODIFIED);
			}
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.NOT_MODIFIED);
		}
	}

	@GetMapping(value = "/clients/getNb")
	public ResponseEntity<Long> getNbOfClients() {
		Long nbOfClients = serviceClient.getNbOfClients();
		if (nbOfClients == null) {
			return new ResponseEntity<Long>(nbOfClients, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Long>(nbOfClients, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/clients/researched/{research}")
	public ResponseEntity<ArrayList<Client>> getClientResearchByName(@PathVariable("research") String research) {
		ArrayList<Client> clients = serviceClient.getClientResearchBar(research);
		System.out.println(clients);
		if (clients == null) {
			return new ResponseEntity<ArrayList<Client>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<ArrayList<Client>>(clients, HttpStatus.OK);
		}
	}
}
