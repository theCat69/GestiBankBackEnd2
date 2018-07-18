package com.wha.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wha.dao.DemandeOuvertureCompteDao;
import com.wha.model.DemandeOuvertureCompte;

@Service("serviceDemandeImpl")
public class ServiceDemandeImpl implements ServiceDemande {

	@Autowired
	private DemandeOuvertureCompteDao demandeDao;

	@Override
	public List<DemandeOuvertureCompte> findDemandeOuvertureCompteByIdConseiller(int id) {
		return demandeDao.findDemandeOuvertureCompteByIdConseiller(id);
	}

	@Override
	public void deleteDemande(int id) {
		demandeDao.deleteDemandeOuvertureCompteById(id);

	}

	@Override
	public DemandeOuvertureCompte getDemandeById(int id) {
		return demandeDao.findById(id);
	}

	@Override
	public void creationCompte(int id_demande) {
		// TODO Auto-generated method stub

	}
}
