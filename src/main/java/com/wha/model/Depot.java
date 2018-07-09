package com.wha.model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
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
