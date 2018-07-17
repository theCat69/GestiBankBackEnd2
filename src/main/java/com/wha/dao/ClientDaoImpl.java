package com.wha.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
		/*
		 * String rqt = "delete from Client c where c.id=?1"; Query q =
		 * getEntityManager().createQuery(rqt).setParameter(1, id); int count =
		 * q.executeUpdate();
		 */
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Client> findAllClients() {
		Query q = getEntityManager().createQuery("select c from Client c");
		//Set<Client> clients = new HashSet<Client>(q.getResultList());
		//List<Integer> sourceList = Lists.newArrayList();
		//ArrayList<Client> listClient = (ArrayList<Client>) q.getResultList();
		/*Set<Client> clients = new HashSet<Client>();
		System.out.println(listClient.toString());
		CollectionUtils.addAll(clients, listClient);
		System.out.println(clients);*/
		return (ArrayList<Client>) q.getResultList();
	}

	@Override
	public void deleteAllClients() {
		@SuppressWarnings("unused")
		int count = getEntityManager().createQuery("delete from Client c").executeUpdate();
	}

	// ne marche pas !!!
	@Override
	public Client updateClientById(int id, Client client) {
		@SuppressWarnings("unused")
		int count = getEntityManager().createQuery("update Client c set c = ?2 where c.id = ?1").setParameter(1, id)
				.setParameter(2, client).executeUpdate();
		return client;

		// update(user);
		// return user;
		// TODO Auto-generated method stub

	}

	@Override
	public void updateClient(Client user) {
		update(user);
	}


	// fonction permettant de récuperer le client par numéro client et de ne pas
	// faire planter l'appli si la requette est null
	// grace au try/catch
	@Override
	public Client findByNumeroClient(int numeroclient) {
		Client client = null;
		String rqt = "select c from Client c where c.numeroclient = ?1";
		Query q = getEntityManager().createQuery(rqt).setParameter(1, numeroclient);

		try {
			client = (Client) q.getSingleResult();
		} catch (NoResultException nre) {
		}

		if (client == null) {
			return null;
		} else {
			return client;
		}
	}

	@Override
	public Long findNbOfNotAttClients() {
		String rqt = "SELECT COUNT(c) FROM Client c where c.idConseiller = ?1";
		Query q = getEntityManager().createQuery(rqt).setParameter(1, 0);
		Long nbOfNotAttClients = (Long) q.getSingleResult();
		return nbOfNotAttClients;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Client> findClientsNotAttributed() {
		String rqt = "SELECT c FROM Client c where c.idConseiller = ?1";
		Query q = getEntityManager().createQuery(rqt).setParameter(1, 0);
		//Set<Client> clients = new HashSet<Client>(q.getResultList());
		return (ArrayList<Client>) q.getResultList();
	}

	@Override
	public Long getNbOfClients() {
		String rqt = "SELECT COUNT(c) FROM Client c";
		Query q = getEntityManager().createQuery(rqt);
		Long nbOfClients = (Long) q.getSingleResult();
		return nbOfClients;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Client> findClientResearchBar(String research) {
		String rqt = "select c from Client c where c.lastName like ?1 order by c.lastName";
		System.out.println(research);
		Query q = getEntityManager().createQuery(rqt).setParameter(1, (research + "%"));
		return (ArrayList<Client>) q.getResultList();
	}
	
	

}
