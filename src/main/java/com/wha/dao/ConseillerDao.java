package com.wha.dao;

import java.util.List;

import com.wha.model.Conseiller;

public interface ConseillerDao {
	
Conseiller findById(int id);
	
	Conseiller findByName(String name);
	
	void save (Conseiller user);
	
	void deleteConseillerById(int id);
	
	List<Conseiller> findAllConseillers(); 
	
	void updateConseiller(Conseiller user);
	
	Conseiller findByMatricule(int matricule);
}
