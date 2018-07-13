package com.wha.dao;

import java.util.ArrayList;

import java.util.List;

import com.wha.model.Client;

import com.wha.model.Conseiller;

public class ConseillerDaoBouchon {
	
	private static List<Conseiller> conseillers;
	{
		/*List<Compte> comptes1 = new ArrayList<Compte>();
		comptes1.add(new Compte(1001L, "Compte courant", new Date(), 0L));
		List<Compte> comptes2 = new ArrayList<Compte>();
		comptes2.add(new Compte(1002L, "Compte courant", new Date(), 0L));
		List<Compte> comptes3 = new ArrayList<Compte>();
		comptes3.add(new Compte(1003L, "Compte courant", new Date(), 0L));*/
		
		@SuppressWarnings("unused")
		List<Client> clients1 = new ArrayList<Client>();
//		clients1.add(new Client(1, "John", "Doe", "[email protected]", "121-232-3435", new Date(), "Ici", comptes1));
//		clients1.add(new Client(2, "John2", "Doe2", "[email protected]", "121-232-3435", new Date(), "Ici", comptes2));
//		clients1.add(new Client(3, "John3", "Doe3", "[email protected]", "121-232-3435", new Date(), "Ici", comptes3));
		
		conseillers = new ArrayList<Conseiller>();
//		conseillers.add(new Conseiller(1, "John", "Doe", "[email protected]", "121-232-3435", "Ici", new Date(), clients1));
//		conseillers.add(new Conseiller(2, "Russ", "Smith", "[email protected]", "343-232-3435", "Là", new Date(), clients1));
//		conseillers.add(new Conseiller(3, "Kate", "Williams", "[email protected]", "876-232-3435", "Là bas", new Date(), clients1));
	}
	
	public List<Conseiller> list() {
		return conseillers;
	}

	public Conseiller get(int id) {
		for (Conseiller c : conseillers) {
			if (c.getId()==id) {
				return c;
			}
		}
		return null;
	}

	public Conseiller create(Conseiller conseiller) {
		conseiller.setId(5);
		conseillers.add(conseiller);
		return conseiller;
	}

	public Long delete(Long id) {
		for (Conseiller c : conseillers) {
			if (c.getId()== id) {
				conseillers.remove(c);
				return id;
			}
		}
		return null;
	}

	public Conseiller update(Long id, Conseiller conseiller) {
		for (Conseiller c : conseillers) {
			if (c.getId()==id) {
				conseiller.setId(c.getId());
				conseillers.remove(c);
				conseillers.add(conseiller);
				return conseiller;
			}
		}
		return null;
	}

}
