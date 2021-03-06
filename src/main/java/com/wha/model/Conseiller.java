package com.wha.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Conseiller")
public class Conseiller extends User {

	private String matricule;
	private Date contratStartingDate;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
	private Set<Client> clients;

	public Conseiller() {
		super();
	}

	public Conseiller(int id, String firstName, String lastName, String email, String password, String phonenumber,
			String address, Date dateOfBirth, Set<Client> clients, String matricule, Date contratStartingDate) {
		super(id, firstName, lastName, email, password, phonenumber, address, dateOfBirth);
		this.clients = clients;
		this.matricule = matricule;
		this.contratStartingDate = contratStartingDate;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Date getContratStartingDate() {
		return contratStartingDate;
	}

	public void setContratStartingDate(Date contratStartingDate) {
		this.contratStartingDate = contratStartingDate;
	}

	public Conseiller(Set<Client> clients) {
		super();
		this.clients = clients;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}
