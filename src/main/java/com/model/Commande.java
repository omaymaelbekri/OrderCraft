package com.model;

import java.util.Date;
import java.util.List;

public class Commande {
	
	private Long id;
	private String numeroCommande;
	private boolean status;
	private Date createdAtDate;
	private Client client;
	private List<ProduitCommande> ProduitsCommandes;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Commande(String numeroCommande, boolean status, Date createdAtDate) {
		super();
		this.numeroCommande = numeroCommande;
		this.status = status;
		this.createdAtDate = createdAtDate;

	}
	public String getNumeroCommande() {
		return numeroCommande;
	}
	public void setNumeroCommande(String numeroCommande) {
		this.numeroCommande = numeroCommande;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getCreatedAtDate() {
		return createdAtDate;
	}
	public void setCreatedAtDate(Date createdAtDate) {
		this.createdAtDate = createdAtDate;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<ProduitCommande> getProduitCommandes() {
		return ProduitsCommandes;
	}
	public void setProduitCommandes(List<ProduitCommande> produitsCommandes) {
		ProduitsCommandes = produitsCommandes;
	}
	@Override
	public String toString() {
		return "Commande [numeroCommande=" + numeroCommande + ", status=" + status + ", createdAtDate=" + createdAtDate
				+ ", client=" + client + ", ProduitCommandes=" + ProduitsCommandes + "]";
	}

	

}
