package web;

import com.model.ProduitCommande;

import java.util.ArrayList;
import java.util.List;

public class ProduitCommandeModel {
    private String motCle;
    private List<ProduitCommande> produitCommandes=new ArrayList<>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<ProduitCommande> getProduitCommande() {
		return produitCommandes;
	}
	public void setProduitCommande(List<ProduitCommande> produitCommandes) {
		this.produitCommandes = produitCommandes;
	}}
