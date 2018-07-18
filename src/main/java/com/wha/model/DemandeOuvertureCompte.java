package com.wha.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DemandeOuvertureCompte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int idClient;
	private int idConseiller;
	private String description;
	private Date date;

	public DemandeOuvertureCompte() {
	}

	public DemandeOuvertureCompte(int id, int idClient, int idConseiller, String description, Date date) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.idConseiller = idConseiller;
		this.description = description;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
