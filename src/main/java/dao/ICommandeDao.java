package dao;

import com.model.Commande;

import java.util.List;

public interface ICommandeDao {
    public Commande save(Commande p);
    public List<Commande> commandesParMC(String mc);
    public Commande getCommande(Long id);

    public void deleteCommande(Long id);
}
