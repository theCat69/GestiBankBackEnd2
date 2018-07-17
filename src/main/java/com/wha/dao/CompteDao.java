package com.wha.dao;

import java.util.Set;

import com.wha.model.Compte;

public interface CompteDao {
	Compte findByRib(Long rib);

	void save(Compte compte);

	void deleteCompteByRib(Long rib);

	Set<Compte> findAllComptes();

	void deleteAllComptes();

	void updateCompte(Compte compte);

	Compte updateCompteByRib(Long rib, Compte compte);
	
	
}
