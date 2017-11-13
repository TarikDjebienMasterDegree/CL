package russelBand.service;

import java.util.List;

public interface IPlateau {
	
	/**
	 * Methode qui nous donne la carte suivante d'une carte dans le plateau de jeu
	 * @param c la carte que l'on questionne
	 * @return sa suivante
	 */
	public ICarte suivante(ICarte c);
	
	/**
	 * Methode qui permet de deplacer la premiere carte
	 * du plateau a la fin du plateau
	 */
	public ICarte deplacerPremiereCarte();
	
	/**
	 * Methode qui permet de recuperer la premiere carte
	 * du plateau
	 */
	public ICarte premiereCarte();
	
	/**
	 * Methode qui permet de recuperer la derniere carte
	 * du plateau
	 */
	public ICarte derniereCarte();
	
	/**
	 * Methode qui permet d'ajouter une carte au plateau
	 * de jeu 
	 */
	public boolean ajouterCarte(ICarte carte);
	
	
	/**
	 * Recupere les cartes du plateau de jeu
	 * @return les cartes du plateau de jeu
	 */
	public List<ICarte> mesCartes();
}
