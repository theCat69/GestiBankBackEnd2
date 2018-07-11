package com.wha.dao;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wha.model.User;
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

	@Override
	public User findByEmail(String email) {
//		System.out.println("i try to request");
		String rqt = "select u from User u where u.email = ?1";
		Query q = getEntityManager().createQuery(rqt).setParameter(1, email);	
//		System.out.println("i did request");
		return  (User) q.getSingleResult();
	}		
}
