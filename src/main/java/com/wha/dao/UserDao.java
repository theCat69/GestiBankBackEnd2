package com.wha.dao;

import com.wha.model.User;

public interface UserDao {
	
	User findByEmail(String email);

}
