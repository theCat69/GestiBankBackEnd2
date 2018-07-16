package com.wha.service;

import java.util.List;
import java.util.Set;

import com.wha.model.Compte;

public interface ServiceCompte {
	Compte findByRib(Long rib);

	void save(Compte compte);

	void deleteCompteByRib(Long rib);

	List<Compte> findAllComptes();

	void deleteAllComptes();

	void updateCompte(Compte compte);

	Compte updateCompteByRib(Long rib, Compte compte);

}
