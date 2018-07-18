package com.wha.service;
import java.util.ArrayList;
import java.util.Set;

import com.wha.model.Client;
import com.wha.model.Compte;
import com.wha.model.DemandeOuvertureCompte;

public interface ServiceClient {

	Client findClientByName(String name);

	void saveClient(Client client);

	ArrayList<Client> findAllClients();

	Client findById(int id);

	void deleteAllClients();

	void updateClient(Client client);

	void deleteClientById(int id);

	void updateClientById(int id, Client client);

	void demandeOuvertureCompte(DemandeOuvertureCompte dOC);

	Long findNbOfNotAttClients();

	ArrayList<Client> findClientsNotAttributed();

	Long getNbOfClients();

	Set<Compte> getCompteCourantRemenuere(String description, int id);
  
	ArrayList<Client> getClientResearchBar(String research);

}