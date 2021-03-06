package com.wha.dao;

import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wha.model.Compte;

@Repository("comptetDao")
public class CompteDaoImpl extends AbstractDao<Long, Compte> implements CompteDao {

	@Override
	public Compte findByRib(Long rib) {
		return getByKey(rib);
	}

	@Override
	public void save(Compte compte) {
		persist(compte);
	}

	@Override
	public void deleteCompteByRib(Long rib) {
		delete(getByKey(rib));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Compte> findAllComptes() {
		Query q = getEntityManager().createQuery("select c from Compte c");
		return (Set<Compte>) q.getResultList();
	}

	@Override
	public void deleteAllComptes() {
		@SuppressWarnings("unused")
		int count = getEntityManager().createQuery("delete from Compte c").executeUpdate();
	}

	@Override
	public void updateCompte(Compte compte) {
		update(compte);
	}

	@Override
	public Compte updateCompteByRib(Long rib, Compte compte) {
		@SuppressWarnings("unused")
		int count = getEntityManager().createQuery("update Compte c set c = ?2 where c.id = ?1").setParameter(1, rib)
				.setParameter(2, compte).executeUpdate();
		return compte;
	}

}
