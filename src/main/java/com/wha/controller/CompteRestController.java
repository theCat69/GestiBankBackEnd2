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
import com.wha.model.Transaction;
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

	@PutMapping("/comptes/operations")
	@Transactional
	public ResponseEntity<Transaction> createOperation(@RequestBody Transaction transaction) {
		if (transaction == null) {
			return new ResponseEntity<Transaction>(transaction, HttpStatus.NO_CONTENT);
		} else {
			serviceCompte.calculTransaction(transaction);
			return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
		}
	}

}
