package com.wha.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	public Transaction() {
	}

	public Transaction(Long rib1, Long rib2, Depot depot, Retrait retrait) {
		this.rib1 = rib1;
		this.rib2 = rib2;
		this.depot = depot;
		this.retrait = retrait;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getRib1() {
		return rib1;
	}

	public void setRib1(Long rib1) {
		this.rib1 = rib1;
	}

	public Long getRib2() {
		return rib2;
	}

	public void setRib2(Long rib2) {
		this.rib2 = rib2;
	}

	public Depot getDepot() {
		return depot;
	}

	public void setDepot(Depot depot) {
		this.depot = depot;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private Long rib1;
	private Long rib2;
	@OneToOne (cascade=CascadeType.ALL)
	private Depot depot;
	@OneToOne (cascade=CascadeType.ALL)
	private Retrait retrait;
}
