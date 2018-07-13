package com.wha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.dao.CompteDao;
import com.wha.model.Compte;

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
			Long rib = (Long) Math.round(Math.random() * (9999999 - 1111111));
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
	public List<Compte> findAllComptes() {
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

}
