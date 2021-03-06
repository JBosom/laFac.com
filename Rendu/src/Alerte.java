package laFac;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Alerte implements Observer
{
	private int seuilPanier;
	private ArrayList<Produit> combinaisonProduit;
	
	public Alerte()
	{
		super();
		seuilPanier = 0;
		combinaisonProduit = new ArrayList<Produit>();
	}
	
	public void setCombinaisonProduit(ArrayList<Produit> combinaisonProduit)
	{
		this.combinaisonProduit.addAll(combinaisonProduit);
	}
	
	public void setSeuilPanier(int seuilPanier)
	{
		this.seuilPanier = seuilPanier;
	}
	
	public void update(Observable arg0, Object arg1)
	{	
		Panier pan = (Panier) arg0;
		if(pan.getListProduits().containsAll(combinaisonProduit))
			System.out.println("-----\nALERTE\nLe panier de " + pan.getNomProprietaire() + " contient la combinaison recherchée.");
		if(pan.coutPanier() > seuilPanier)
			System.out.println("-----\nALERTE\nLe panier de " + pan.getNomProprietaire() + " a depassé le seuil des " + seuilPanier + " €.\n-----");
	}
	
}
