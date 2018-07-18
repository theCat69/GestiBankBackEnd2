package com.wha.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "Client")
public class Client extends User {

	private int numeroclient;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
	private Set<Compte> comptes;

	private int idConseiller;

	public Client() {
		super();
	}

	public Client(int id, String firstName, String lastName, String email, String password, String phonenumber,
			String address, Date dateOfBirth, int numeroclient, Set<Compte> comptes, int idconseiller) {
		super(id, firstName, lastName, email, password, phonenumber, address, dateOfBirth);
		this.numeroclient = numeroclient;
		this.comptes = comptes;
		this.idConseiller = idconseiller;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public int getNumeroclient() {
		return numeroclient;
	}

	public void setNumeroclient(int numeroclient) {
		this.numeroclient = numeroclient;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

}
