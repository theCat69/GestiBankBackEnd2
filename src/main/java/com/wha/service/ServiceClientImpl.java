package com.wha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.dao.ClientDao;
import com.wha.model.Client;

@Service("serviceClientImpl")
public class ServiceClientImpl implements ServiceClient {

	@Autowired
	private ClientDao clientDao;

	@Override
	public Client findClientByName(String name) {
		return clientDao.findByName(name);
	}

	@Override
	public void saveClient(Client client) {
		//cette partie ne sert que à créé des numéro client aléatoire, de vérifié si il éxiste, et si non l'attribué au client
		boolean numeroClientExist = true;
		while (numeroClientExist) {
			int numeroclient = (int) Math.round(Math.random() * (9999 - 1111));
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
	public void updateClientById(int id, Client client) {
		clientDao.updateClientById(id, client);
	}

	@Override
	public void deleteAllClients() {
		clientDao.deleteAllClients();
	}

}