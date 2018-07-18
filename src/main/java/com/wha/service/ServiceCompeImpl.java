package com.wha.service;

import java.util.Set;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.dao.ClientDao;
import com.wha.dao.CompteDao;
import com.wha.model.Client;
import com.wha.model.Compte;
import com.wha.model.DemandeOuvertureCompte;
import com.wha.model.Operation;

@Service("serviceCompteImpl")
public class ServiceCompeImpl implements ServiceCompte {

	@Autowired
	private CompteDao compteDao;
	
	@Autowired
	private ClientDao clientDao;

	@Override
	public Compte findByRib(Long rib) {
		return compteDao.findByRib(rib);
	}

	@Override
	public Long save(Compte compte) {
		Long RIB=0L;
		boolean ribExist = true;
		while (ribExist) {
			Long rib = (Long) Math.round(Math.random() * 8888888 + 1111111);
			Compte numeroRibExist = compteDao.findByRib(rib);
			if (numeroRibExist == null) {
				RIB=rib;
				compte.setRib(rib);
				ribExist = false;
			}
		}
		compteDao.save(compte);
		return RIB;
	}

	@Override
	public void deleteCompteByRib(Long rib) {
		compteDao.deleteCompteByRib(rib);
	}

	@Override
	public Set<Compte> findAllComptes() {
		return compteDao.findAllComptes();
	}

	@Override
	public void deleteAllComptes() {
		compteDao.deleteAllComptes();
	}

	@Override
	public void updateCompte(Compte compte) {
		compteDao.updateCompte(compte);
	}

	@Override
	public Compte updateCompteByRib(Long rib, Compte compte) {
		return compteDao.updateCompteByRib(rib, compte);
	}

	@Override
	public Compte calculSolde(Compte compte) {
		System.out.println("********************CALCUL DU SOLDE***************************");
		Long res = compte.getSolde();
		for (Operation o : compte.getOperations()) {
			System.out.println(o.getClass().getSimpleName());
			System.out.println("montant=" + o.getSomme());
			if (o.getClass().getSimpleName().equals("Depot")) {
				res += o.getSomme();
			}
			if (o.getClass().getSimpleName().equals("Retrait")) {
				res -= o.getSomme();
			} else {
				System.err.println("C'est quoi ce bordel!!!");
			}
		}
		System.out.println("calcule du solde res = " + res);
		compte.setSolde(res);
		return compte;
	}

	@Override
	public Compte createCompte(DemandeOuvertureCompte demande) {
		Compte compte=new Compte();
		compte.setDateCreation(new Date());
		compte.setDescription(demande.getDescription());
		Long rib = save(compte);
		Client client = clientDao.findById(demande.getIdClient());
		client.getComptes().add(findByRib(rib));
		clientDao.updateClient(client);
		return findByRib(rib);
	}

}
