package com.wha.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wha.model.User;
import com.wha.service.ServiceUser;

@RestController
public class UserRestController {
	
	@Autowired
	private ServiceUser serviceUser;
	
	public UserRestController() {

	}

	@PostMapping("/users/connexion")
	public ResponseEntity<User> connexion(@RequestBody String form) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
//		System.out.println(form);
		User test = mapper.readValue(form, User.class);
//		System.out.println(test.toString());
		User user = this.serviceUser.connectUser(test.getEmail(),test.getPassword());
		try {
//		System.out.println("i TRRYYY");
		return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		catch (Exception e) {
//		System.out.println(e.getMessage());
//		System.out.println("i Catch");
		return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
	}
}
