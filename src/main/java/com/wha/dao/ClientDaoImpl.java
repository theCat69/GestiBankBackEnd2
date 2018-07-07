package com.wha.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wha.model.Client;

@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

	@Override
	public Client findById(int id) {
		// Query q = getEntityManager().createQuery("select c from Client c where id =
		// ?1").setParameter(1, id);
		// return (Client) q.getSingleResult();
		return getByKey(id);
	}

	@Override
	public Client findByName(String name) {
		String rqt = "select c from Client c where c.name = ?1";
		Query q = getEntityManager().createQuery(rqt).setParameter(1, name);
		return (Client) q.getSingleResult();
	}

	@Override
	public void save(Client user) {
		persist(user);
	}

	@Override
	public void deleteClientById(int id) {
		delete(getByKey(id));
	}

	@Override
	public List<Client> findAllClients() {
		Query q = getEntityManager().createQuery("select c from Client c");
		return (List<Client>) q.getResultList();
	}

	@Override
	public void deleteAllClients() {
		int count = getEntityManager().createQuery("delete from Client c").executeUpdate();
	}

	@Override
	public Client updateClientById(int id, Client client) {
		int count = getEntityManager().createQuery("update Client c set c = ?2 where c.id = ?1").setParameter(1, id)
				.setParameter(2, client).executeUpdate();
		return client;

		// update(user);
		// return user;
		// TODO Auto-generated method stub

	}

	@Override
	public Client updateClient(Client user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//fonction permettant de récuperer le client par numéro client et de ne pas faire planter l'appli si la requette est null
	//grace au try/catch
	@Override
	public Client findByNumeroClient(int numeroclient) {
		Client client = null;
		String rqt = "select c from Client c where c.numeroclient = ?1";
		Query q = getEntityManager().createQuery(rqt).setParameter(1, numeroclient);
		
		try {
			client = (Client) q.getSingleResult();
		}
		catch (NoResultException nre) {
		}

		if (client == null) {
			return null;
		} else {
			return client;
		}
	}

}
