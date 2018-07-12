package com.wha.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DEPOT")
public class Depot extends Operation {

	public Depot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Depot(Long somme, Date date) {
		super(somme, date);
		// TODO Auto-generated constructor stub
	}

}
