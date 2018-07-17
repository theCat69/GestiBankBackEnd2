package com.wha.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.dao.CompteDao;
import com.wha.model.Compte;
import com.wha.model.Transaction;

@Service("serviceCompteImpl")
public class ServiceCompeImpl implements ServiceCompte {

	@Autowired
	private CompteDao compteDao;

	@Override
	public Compte findByRib(Long rib) {
		return compteDao.findByRib(rib);
	}

	@Override
	public void save(Compte compte) {
		boolean ribExist = true;
		while (ribExist) {
			Long rib = (Long) Math.round(Math.random() * 8888888 + 1111111);
			Compte numeroRibExist = compteDao.findByRib(rib);
			if (numeroRibExist == null) {
				compte.setRib(rib);
				ribExist = false;
			}
		}
		compteDao.save(compte);
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
		System.out.println("********************CALCUL DU SOLDE***************************");
		System.out.println("rib1=" + transaction.getRib1() + ", rib2=" + transaction.getRib2());
		Compte compte1 = findByRib(transaction.getRib1());
		Compte compte2 = findByRib(transaction.getRib2());
		compte2.getOperations().add(transaction.getDepot());
		compte1.getOperations().add(transaction.getRetrait());
		compte2.setSolde(compte2.getSolde() + transaction.getDepot().getSomme());
		compte1.setSolde(compte1.getSolde() - transaction.getRetrait().getSomme());
		System.out.println(compte1.toString() + ", " + compte2.toString());
		updateCompte(compte1);
		updateCompte(compte2);
	}

}
