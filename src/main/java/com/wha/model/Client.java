package com.wha.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("CLIENT")
public class Client extends User {
	
	private int numeroclient;
	
	@ManyToOne
	private Conseiller conseiller;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=false, fetch=FetchType.EAGER)
	private List<Compte> comptes;

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Client() {
		super();
	}

	public Client(int id, String firstName, String lastName, String email, String password, String phonenumber, Date date, String address, List<Compte> comptes, Conseiller conseiller) {
		super(id, firstName, lastName, email, password, phonenumber, address, date);
		this.comptes = comptes;
		this.conseiller = conseiller;
	}

	public int getNumeroclient() {
		return numeroclient;
	}

	public void setNumeroclient(int numeroclient) {
		this.numeroclient = numeroclient;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	
}
