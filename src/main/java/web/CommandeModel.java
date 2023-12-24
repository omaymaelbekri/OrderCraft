package web;

import com.model.Commande;

import java.util.ArrayList;
import java.util.List;

public class CommandeModel {
    private String motCle;
    private List<Commande> commandes=new ArrayList<>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

}
