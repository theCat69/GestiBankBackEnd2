package com.wha.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wha.model.DemandeOuvertureCompte;

@Repository("demandeOuvertureCompteDao")
public class DemandeOuvertureCompteDaoImpl extends AbstractDao<Integer, DemandeOuvertureCompte>implements DemandeOuvertureCompteDao {

	@Override
	public DemandeOuvertureCompte findById(int id) {
		return getByKey(id);
	}

	@Override
	public void save(DemandeOuvertureCompte dOC) {
		persist(dOC);
	}

	@Override
	public void deleteDemandeOuvertureCompteById(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeOuvertureCompte> findAllDemandesOuvertureComptes() {
		Query q = getEntityManager().createQuery("select d from DemandeOuvertureCompte d");
		return (List<DemandeOuvertureCompte>) q.getResultList();
	}

}
