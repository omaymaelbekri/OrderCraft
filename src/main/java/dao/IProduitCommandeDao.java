package dao;


import com.model.ProduitCommande;

import java.util.List;

public interface IProduitCommandeDao {

    public ProduitCommande save(ProduitCommande p);
    public List<ProduitCommande> produitCommandesParMC(String mc);
    public ProduitCommande getProduitCommande(Long id);
    public ProduitCommande update(ProduitCommande p);
    public void deleteProduitCommande(Long id);
}
