package com.wha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.dao.ConseillerDao;
import com.wha.model.Conseiller;


@Service("serviceConseillerImpl")
public class ServiceConseillerImpl implements ServiceConseiller {

	@Autowired
	private ConseillerDao conseillerDao;

	@Override
	public Conseiller findConseillerByName(String name) {
		return conseillerDao.findByName(name);
	}

	@Override
	public void save(Conseiller conseiller) {
		int numeroConseiller = (int) (Math.random() * 888888 + 111111);
		String matricule = "C" + numeroConseiller;
		conseiller.setMatricule(matricule);
		conseillerDao.save(conseiller);
	}

	@Override
	public List<Conseiller> findAllConseillers() {
		return conseillerDao.findAllConseillers();
	}

	@Override
	public Conseiller findById(int id) {
		return conseillerDao.findById(id);
	}

	@Override
	public void updateConseiller(Conseiller conseiller) {
		conseillerDao.updateConseiller(conseiller);
	}

	@Override
	public void deleteConseillerById(int id) {
		conseillerDao.deleteConseillerById(id);

	}

	@Override
	@Transactional
	public void updateConseillerById(int id, Conseiller conseiller) {
		Conseiller oldConseiller = conseillerDao.findById(id);
		System.out.println(oldConseiller);
		conseiller.setMatricule(oldConseiller.getMatricule());
		conseiller.setPassword(oldConseiller.getPassword());
		conseiller.setDateOfBirth(oldConseiller.getDateOfBirth());
		conseiller.setClients(oldConseiller.getClients());
		conseiller.setContratStartingDate(oldConseiller.getContratStartingDate());
		conseillerDao.updateConseiller(conseiller);
	}
	
}


