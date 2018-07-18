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
		if (user == null) {
			return null;
		} else {
			if (password.equals(user.getPassword())) {

				return user;
			} else {
				return null;
			}
		}
	}
}
