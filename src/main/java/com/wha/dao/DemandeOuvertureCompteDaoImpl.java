package com.wha.dao;

import java.util.Date;
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
		dOC.setDate(new Date());
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

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeOuvertureCompte> findDemandeOuvertureCompteByIdConseiller(int id) {
		Query q = getEntityManager().createQuery("select d from DemandeOuvertureCompte d where d.idConseiller = ?1").setParameter(1, id);
		return (List<DemandeOuvertureCompte>) q.getResultList();
	}
}
