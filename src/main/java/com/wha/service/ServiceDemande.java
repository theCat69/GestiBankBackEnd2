package com.wha.service;

import java.util.List;

import com.wha.model.DemandeOuvertureCompte;

public interface ServiceDemande {

	List<DemandeOuvertureCompte> findDemandeOuvertureCompteByIdConseiller(int id);

	void deleteDemande(int id);

	DemandeOuvertureCompte getDemandeById(int id);

	void creationCompte(int id_demande);
}
