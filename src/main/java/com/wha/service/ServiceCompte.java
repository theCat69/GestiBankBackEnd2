package com.wha.service;

import java.util.Set;

import com.wha.model.Compte;
import com.wha.model.Transaction;

public interface ServiceCompte {
	Compte findByRib(Long rib);

	void save(Compte compte);

	void deleteCompteByRib(Long rib);

	Set<Compte> findAllComptes();

	void deleteAllComptes();

	void updateCompte(Compte compte);

	Compte updateCompteByRib(Long rib, Compte compte);

	void calculTransaction(Transaction transaction);

}
