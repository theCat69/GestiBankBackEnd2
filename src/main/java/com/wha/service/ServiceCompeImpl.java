package com.wha.service;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.dao.ClientDao;
import com.wha.dao.CompteDao;
import com.wha.dao.TransactionDao;
import com.wha.model.Client;
import com.wha.model.Compte;
import com.wha.model.DemandeOuvertureCompte;
import com.wha.model.Transaction;

@Service("serviceCompteImpl")
public class ServiceCompeImpl implements ServiceCompte {

	@Autowired
	private CompteDao compteDao;

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private TransactionDao transactionDao;

	@Override
	public Compte findByRib(Long rib) {
		return compteDao.findByRib(rib);
	}

	@Override
	public Long save(Compte compte) {
		Long RIB = 0L;
		boolean ribExist = true;
		while (ribExist) {
			Long rib = (Long) Math.round(Math.random() * 8888888 + 1111111);
			Compte numeroRibExist = compteDao.findByRib(rib);
			if (numeroRibExist == null) {
				RIB = rib;
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
	public void calculTransaction(Transaction transaction) {
		Compte compte1 = findByRib(transaction.getRib1());
		Compte compte2 = findByRib(transaction.getRib2());
		compte2.getOperations().add(transaction.getDepot());
		compte1.getOperations().add(transaction.getRetrait());
		compte2.setSolde(compte2.getSolde() + transaction.getDepot().getSomme());
		compte1.setSolde(compte1.getSolde() - transaction.getRetrait().getSomme());
		transactionDao.save(transaction);
		updateCompte(compte1);
		updateCompte(compte2);
	}

	@Override
	public Compte createCompte(DemandeOuvertureCompte demande) {
		Compte compte = new Compte();
		compte.setDateCreation(new Date());
		compte.setDescription(demande.getDescription());
		compte.setSolde(0L);
		Long rib = save(compte);
		Client client = clientDao.findById(demande.getIdClient());
		client.getComptes().add(findByRib(rib));
		clientDao.updateClient(client);
		return findByRib(rib);
	}

	@Override
	public Compte calculSolde(Compte compte) {
		// TODO Auto-generated method stub
		return null;
	}

}
