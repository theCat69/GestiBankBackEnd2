package com.wha.model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "OPERATION_TYPE", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(  
	    use = JsonTypeInfo.Id.NAME,  
	    include = JsonTypeInfo.As.PROPERTY,  
	    property = "OPERATION_TYPE",
	    visible = true)  
@JsonSubTypes({ @JsonSubTypes.Type(value = Depot.class, name = "DEPOT"),
		@JsonSubTypes.Type(value = Retrait.class, name = "RETRAIT") })
public abstract class Operation {
	@Id
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Long somme;
	private Date date;

	public Operation() {
	}

	public Operation(Long somme, Date date) {
		super();
		this.somme = somme;
		this.date = date;
	}

	public Long getSomme() {
		return somme;
	}

	public void setSomme(Long somme) {
		this.somme = somme;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
