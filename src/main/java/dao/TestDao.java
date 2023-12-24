package dao;

import java.util.List;

import com.model.Produit;

public class TestDao {
	
	public static void main(String[] args) {
	ProduitDaoImpl dao=new ProduitDaoImpl();
	Produit p1=dao.save(new Produit("HP",600,15));
	Produit p2=dao.save(new Produit("Imprimante",700,25));
	Produit p3=dao.save(new Produit("Clabier",200,30));
     System.out.println(p1.toString());
     System.out.println(p2.toString());
     System.out.println(p3.toString());
     List<Produit> prods= dao.produitsParMC("%H%");
     for(Produit p:prods) {
    	 System.out.println(p.toString());
    	 
     }
	}
}