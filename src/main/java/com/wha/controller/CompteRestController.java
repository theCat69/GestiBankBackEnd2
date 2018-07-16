package com.wha.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.model.Compte;
import com.wha.model.Operation;
import com.wha.service.ServiceCompte;

@RestController
public class CompteRestController {

	@Autowired
	private ServiceCompte serviceCompte;

	@GetMapping("/comptes/{rib}")
	public Compte getCompteByRib(@PathVariable("rib") Long rib) {
		return serviceCompte.findByRib(rib);
	}

	@GetMapping("/comptes/{rib}/operations")
	public Set<Operation> getComptes(@PathVariable("rib") Long rib) {
		Compte compte = serviceCompte.findByRib(rib);
		return compte.getOperations();
	}

	@PutMapping("/comptes/{rib}/operations")
	@Transactional
	public ResponseEntity<Compte> createOperation(@PathVariable("rib") Long rib, @RequestBody Operation operation) {
		System.out.println("Opération = " + operation.toString());
		Compte compte = serviceCompte.findByRib(rib);
		if (compte == null) {
			return new ResponseEntity<Compte>(compte, HttpStatus.NOT_FOUND);
		} else {
			if (operation == null) {
				return new ResponseEntity<Compte>(compte, HttpStatus.NO_CONTENT);
			} else {
				compte.getOperations().add(operation);
				compte = serviceCompte.calculSolde(compte);
				serviceCompte.updateCompte(compte);
				return new ResponseEntity<Compte>(compte, HttpStatus.OK);
			}
		}
	}

}
