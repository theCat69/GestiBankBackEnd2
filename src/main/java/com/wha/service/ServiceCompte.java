package com.wha.service;

import java.util.List;

import com.wha.model.Compte;
import com.wha.model.Operation;

public interface ServiceCompte {
	Compte findByRib(Long rib);

	void save(Compte compte);

	void deleteCompteByRib(Long rib);

	List<Compte> findAllComptes();

	void deleteAllComptes();

	void updateCompte(Compte compte);

	Compte updateCompteByRib(Long rib, Compte compte);

	Compte calculSolde(Long rib, Operation operation);
}
