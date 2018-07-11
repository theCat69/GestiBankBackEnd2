package com.wha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.dao.UserDao;
import com.wha.model.User;

@Service("serviceUserImpl")
class ServiceUserImpl implements ServiceUser {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User connectUser(String email, String password) {
		
		User user = userDao.findByEmail(email);
//		System.out.println("i did Dao call");
		if (user == null) {
//			System.out.println("user is null");
			return null;
		}
		else {
			if (password.equals(user.getPassword())) {
				
//				System.out.println("all good go to WebService");
				return user;
			}
			else {
//				System.out.println("pasword from front : " + password + " / DBpassword : " + user.getPassword());
//				System.out.println((password == user.getPassword()));
//				System.out.println("password is wrong");
				return null;
			}
		}
	}
}
