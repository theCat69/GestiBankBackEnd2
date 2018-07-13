package com.wha.model;

public class DemandeOuvertureCompte {
	
	private int idClient;
	private int idConseiller;
	private String description;
	
	public DemandeOuvertureCompte() {	
	}

	public DemandeOuvertureCompte(int idClient, int idConseiller, String description) {
		super();
		this.idClient = idClient;
		this.idConseiller = idConseiller;
		this.description = description;
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
	
}
