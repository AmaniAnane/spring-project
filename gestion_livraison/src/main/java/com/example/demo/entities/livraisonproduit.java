package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class livraisonproduit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int date;
	private int quantité;
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getQuantité() {
		return quantité;
	}
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	public livraisonproduit(int date, int quantité) {
		super();
		this.date = date;
		this.quantité = quantité;
	}
	@ManyToOne
	@JoinColumn(name = "id_produit")
	private Produit Ps;
	@ManyToOne
	@JoinColumn(name = "id_facture")
	
	private facture Fs;
	@ManyToOne
	@JoinColumn(name = "id_transport")
	private transport Ts;
	@ManyToOne
	@JoinColumn(name = "id_boutique")
	private boutique Bs;
	
	
	public livraisonproduit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}