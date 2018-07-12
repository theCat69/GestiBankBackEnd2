package com.wha.service;

import com.wha.model.User;

public interface ServiceUser {
	
	User findByEmail (String email);
	
	User connectUser (String email, String password);
}
