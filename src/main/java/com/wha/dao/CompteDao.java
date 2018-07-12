package com.wha.dao;

import java.util.List;

import com.wha.model.Compte;

public interface CompteDao {
	Compte findByRib(Long rib);

	void save(Compte compte);

	void deleteCompteByRib(Long rib);

	List<Compte> findAllComptes();

	void deleteAllComptes();

	void updateCompte(Compte compte);

	Compte updateCompteByRib(Long rib, Compte compte);
}
