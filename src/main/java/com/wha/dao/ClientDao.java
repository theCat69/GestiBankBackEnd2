package com.wha.dao;

import java.util.Set;

import com.wha.model.Client;

public interface ClientDao {
	
	Client findById(int id);
	
	Client findByName(String name);
	
	void save (Client user);
	
	void deleteClientById(int id);
	
	Set<Client> findAllClients(); 
	
	void deleteAllClients();
	
	void updateClient(Client user);
	
	Client updateClientById(int id, Client user);
	
	Client findByNumeroClient(int numeroclient);
	
	Long findNbOfNotAttClients();
	
	Set<Client> findClientsNotAttributed();
	
	Long getNbOfClients();
	
}
