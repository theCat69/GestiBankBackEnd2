package com.wha.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wha.model.Compte;
import com.wha.service.ServiceCompte;

public class CompteRestController {

	private ServiceCompte serviceCompte;

	@GetMapping("/compte/{rib}")
	public Compte getCompteByRib(@PathVariable("rib") Long rib) {
		return serviceCompte.findByRib(rib);
	}

	@PostMapping(value = "/comptes")
	@Transactional
	public ResponseEntity<Compte> createCompte(@RequestBody Compte compte) {

		serviceCompte.save(compte);
		return new ResponseEntity<Compte>(compte, HttpStatus.OK);
	}

}
