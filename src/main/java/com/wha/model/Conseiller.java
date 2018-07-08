package com.wha.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("CONSEILLER")
public class Conseiller extends User {

	public Conseiller() {
		super();
	}

	public Conseiller(int id, String firstName, String lastName, String email, String password, String phonenumber, String address,
			Date dateOfBirth, List<Client> clients) {
		super(id, firstName, lastName, email, password, phonenumber, address, dateOfBirth);
		this.clients = clients;
	}

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	private List<Client> clients;

	public Conseiller(List<Client> clients) {
		super();
		this.clients = clients;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
}
