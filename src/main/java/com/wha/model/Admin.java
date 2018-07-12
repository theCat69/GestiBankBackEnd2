package com.wha.model;

import java.util.Date;

import javax.persistence.Entity;


@SuppressWarnings("serial")
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("Admin")
public class Admin extends User {
	private String matricule;
	private String fonction;
	private Date contratStartingDate;

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public Date getContratStartingDate() {
		return contratStartingDate;
	}

	public void setContratStartingDate(Date contratStartingDate) {
		this.contratStartingDate = contratStartingDate;
	}
 
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String firstName, String lastName, String email, String password, String phonenumber, String address,
			Date dateOfBirth, String matricule, String fonction, Date contratStartingDate) {
		super(id, firstName, lastName, email, password, phonenumber, address, dateOfBirth);
		this.matricule = matricule;
		this.fonction = fonction;
		this.contratStartingDate = contratStartingDate;
	}

}
