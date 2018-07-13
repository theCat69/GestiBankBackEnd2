package com.wha.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wha.model.Conseiller;

@Repository("ConseillerDao")
public class ConseillerDaoImpl extends AbstractDao<Integer, Conseiller> implements ConseillerDao {

	@Override
	public Conseiller findById(int id) {
		// Query q = getEntityManager().createQuery("select c from Conseiller c where id =
		// ?1").setParameter(1, id);
		// return (Conseiller) q.getSingleResult();
		return getByKey(id);
	}

	@Override
	public Conseiller findByName(String name) {
		String rqt = "select c from Conseiller c where c.name = ?1";
		Query q = getEntityManager().createQuery(rqt).setParameter(1, name);
		return (Conseiller) q.getSingleResult();
	}

	@Override
	public void save(Conseiller user) {
		persist(user);
	}

	@Override
	public void deleteConseillerById(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conseiller> findAllConseillers() {
		Query q = getEntityManager().createQuery("select c from Conseiller c");
		return (List<Conseiller>) q.getResultList();
	}

	@Override
	public void updateConseiller(Conseiller user) {
		update(user);
	}

	@Override
	public Conseiller findByMatricule(int matricule) {
		Conseiller Conseiller = null;
		String rqt = "select c from Conseiller c where c.matricule = ?1";
		Query q = getEntityManager().createQuery(rqt).setParameter(1, matricule);
		
		try {
			Conseiller = (Conseiller) q.getSingleResult();
		}
		catch (NoResultException nre) {
		}

		if (Conseiller == null) {
			return null;
		} else {
			return Conseiller;
		}
	}



}
