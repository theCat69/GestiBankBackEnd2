package com.wha.service;

import java.util.List;

import com.wha.model.Conseiller;

public interface ServiceConseiller {
	
	Conseiller findConseillerByName(String name);

	void save(Conseiller conseiller);

	List<Conseiller> findAllConseillers();

	Conseiller findById(int id);

	void updateConseiller(Conseiller conseiller);

	void deleteConseillerById(int id);

	void updateConseillerById(int id, Conseiller conseiller);
}
