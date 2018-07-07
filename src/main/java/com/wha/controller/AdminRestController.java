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

import com.wha.dao.AdminDaoBouchon;
import com.wha.model.Admin;

@RestController
public class AdminRestController {
	private AdminDaoBouchon adminDAO;

	public AdminRestController() {
		this.adminDAO = new AdminDaoBouchon();
	}

	@GetMapping("/admins")
	public List<Admin> getAdmins() {
		return adminDAO.list();
	}

	@GetMapping("/admins/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("id") int id) {

		Admin admin = adminDAO.get(id);

		if (null == admin) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
	
	@PostMapping(value = "/admins")
	public ResponseEntity<Admin> createCustomer(@RequestBody Admin admin){
		
		adminDAO.create(admin);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
	
	@DeleteMapping("/admins/{id}")
	public ResponseEntity<Integer> deleteAdmin(@PathVariable int id) {

//		if (null == adminDAO.delete(id)) {
//			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
//		}
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}
	
	@PutMapping("/admins/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
		admin = adminDAO.update(id, admin);

		if (null == admin) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
}
