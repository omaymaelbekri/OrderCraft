package com.model;

public class ProduitCommande {

		private Long id;
		private int quantite;
		private double sousTotal;
		Commande commande;
		Produit produit;

		public ProduitCommande() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ProduitCommande(int quantite, double sousTotal) {
			super();
			this.quantite = quantite;
			this.sousTotal = sousTotal;			
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public int getQuantite() {
			return quantite;
		}
		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}
		public double getSousTotal() {
			return sousTotal;
		}
		public void setSousTotal(double sousTotal) {
			this.sousTotal = sousTotal;
		}
		public Commande getCommande() {
			return commande;
		}
		public void setCommande(Commande commande) {
			this.commande = commande;
		}
		public Produit getProduit() {
			return produit;
		}
		public void setProduit(Produit produit) {
			this.produit = produit;
		}
		@Override
		public String toString() {
			return "ProduitCommande [quantite=" + quantite + ", SousTotal=" + sousTotal + ",produit=" + produit.getDesignation() + "]";
		}


}
