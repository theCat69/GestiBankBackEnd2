package com.wha.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.dao.ConseillerDaoBouchon;
import com.wha.model.Conseiller;

@RestController
public class ConseillerRestController {
	private ConseillerDaoBouchon conseillerDao;

	public ConseillerRestController() {
		this.conseillerDao = new ConseillerDaoBouchon();
	}

	@GetMapping("/conseillers")
	public List<Conseiller> getConseillers() {
		return conseillerDao.list();
	}

	@GetMapping("/conseillers/{id}")
	public ResponseEntity<Conseiller> getConseiller(@PathVariable("id") int id) {

		Conseiller conseiller = conseillerDao.get(id);

		if (null == conseiller) {
			return new ResponseEntity<Conseiller>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Conseiller>(conseiller, HttpStatus.OK);
	}

	@PostMapping(value = "/conseillers")
	public ResponseEntity<Conseiller> createConseiller(@RequestBody Conseiller conseiller) {

		conseillerDao.create(conseiller);
		return new ResponseEntity<Conseiller>(conseiller, HttpStatus.OK);
	}

	@DeleteMapping("/conseillers/{id}")
	public ResponseEntity<Long> deleteConseiller(@PathVariable Long id) {

		if (null == conseillerDao.delete(id)) {
			return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

	@PutMapping("/conseillers/{id}")
	public ResponseEntity<Conseiller> updateConseiller(@PathVariable Long id, @RequestBody Conseiller conseiller) {
		conseiller = conseillerDao.update(id, conseiller);

		if (null == conseiller) {
			return new ResponseEntity<Conseiller>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Conseiller>(conseiller, HttpStatus.OK);
	}
}
