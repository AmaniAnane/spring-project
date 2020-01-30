package com.example.demo.entities;
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Long getReference() {
		return reference;
	}
	public void setReference(Long reference) {
		this.reference = reference;
	}
	public String getMarque() {
		return marque;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private Long reference;
	private String marque ;
	private float prix ;
	@OneToMany(mappedBy="Ps")
	private Collection <livraisonproduit> livraisonproduit;
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
