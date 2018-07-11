package com.wha.dao;

import java.util.ArrayList;
import java.util.List;

import com.wha.model.Admin;

public class AdminDaoBouchon {
	private static List<Admin> admins;
	{		
		admins = new ArrayList<Admin>();
//		admins.add(new Admin(1, "Admin", "Admin", "[email protected]", "121-232-3435", "Ici", new Date(), "0541", "Admin", new Date()));
//		admins.add(new Admin(2, "Admin2", "Admin2", "[email protected]", "122-232-3435", "Ici", new Date(), "0542", "Admin", new Date()));
//		admins.add(new Admin(3, "Admin3", "Admin3", "[email protected]", "123-232-3435", "Ici", new Date(), "0543", "Admin", new Date()));
	}
	
	public List<Admin> list() {
		return admins;
	}

	public Admin get(int id) {
		for (Admin a : admins) {
			if (a.getId() == id ) {
				return a;
			}
		}
		return null;
	}

	public Admin create(Admin admin) {
		//admin.setId(System.currentTimeMillis());
		admins.add(admin);
		return admin;
	}

	@SuppressWarnings("null")
	public int delete(int id) {
		for (Admin a : admins) {
			if (a.getId() == id) {
				admins.remove(a);
				return id;
			}
		}
		return (Integer) null;
	}

	public Admin update(int id, Admin admin) {
		for (Admin a : admins) {
			if (a.getId()== id) {
				admin.setId(a.getId());
				admins.remove(a);
				admins.add(admin);
				return admin;
			}
		}
		return null;
	}
}
