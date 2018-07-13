package com.wha.dao;

import java.util.List;

import com.wha.model.DemandeOuvertureCompte;

public interface DemandeOuvertureCompteDao {
	
	DemandeOuvertureCompte findById(int id);
	
	void save (DemandeOuvertureCompte dOC);
	
	void deleteDemandeOuvertureCompteById(int id);
	
	List<DemandeOuvertureCompte> findAllDemandesOuvertureComptes(); 
	
}
