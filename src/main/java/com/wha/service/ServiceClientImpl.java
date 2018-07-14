package com.wha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.dao.ClientDao;
import com.wha.dao.DemandeOuvertureCompteDao;
import com.wha.model.Client;
import com.wha.model.DemandeOuvertureCompte;

@Service("serviceClientImpl")
public class ServiceClientImpl implements ServiceClient {

	@Autowired
	private ClientDao clientDao;
	@Autowired
	private DemandeOuvertureCompteDao demandeOuvertureCompteDao;
	
	@Override
	public Client findClientByName(String name) {
		return clientDao.findByName(name);
	}

	@Override
	public void saveClient(Client client) {
		//cette partie ne sert que à créé des numéro client aléatoire, de vérifié si il éxiste, et si non l'attribué au client
		boolean numeroClientExist = true;
		while (numeroClientExist) {
			int numeroclient = (int) (Math.random() * 8888 + 1111);
			Client numeroClientExistclient = clientDao.findByNumeroClient(numeroclient);
			if (numeroClientExistclient == null) {
				client.setNumeroclient(numeroclient);
				numeroClientExist = false;
			}
		}
		//si vous voulez sauvegarder sans logic métier juste faire la commande qui suit
		clientDao.save(client);
	}

	@Override
	public List<Client> findAllClients() {
		return clientDao.findAllClients();
	}

	@Override
	public Client findById(int id) {
		return clientDao.findById(id);
	}

	@Override
	public void updateClient(Client client) {
		clientDao.updateClient(client);
	}

	@Override
	public void deleteClientById(int id) {
		clientDao.deleteClientById(id);

	}

	@Override
	@Transactional
	public void updateClientById(int id, Client client) {
		Client oldclient = clientDao.findById(id);
		System.out.println(oldclient);
		client.setNumeroclient(oldclient.getNumeroclient());
		client.setPassword(oldclient.getPassword());
		client.setComptes(oldclient.getComptes());
		client.setDateOfBirth(oldclient.getDateOfBirth());
		clientDao.updateClient(client);
	}

	@Override
	public void deleteAllClients() {
		clientDao.deleteAllClients();
	}

	@Override
	public void demandeOuvertureCompte(DemandeOuvertureCompte dOC) {
		demandeOuvertureCompteDao.save(dOC);	
	}

	@Override
	public Long findNbOfNotAttClients() {
		return clientDao.findNbOfNotAttClients();
	}

	@Override
	public List<Client> findClientsNotAttributed() {
		return clientDao.findClientsNotAttributed();
	}
	
	
	
//	@Override
//	public void demandeOuvertureCompte(DemandeOuvertureCompte dOC) {
//		clientDao.addDemandeOuvertureCompte(dOC);
//	}

}