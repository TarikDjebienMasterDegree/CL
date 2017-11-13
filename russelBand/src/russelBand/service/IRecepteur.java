package russelBand.service;

/**
 * Un recepteur est soit un porcelet, soit une case
 */
public interface IRecepteur {
	
	
	/**
	 * Methode permettant de recevoir un porcelet
	 * @param p le porcelet 
	 */
	public void recevoir(IPorcelet p);
	
	/**
	 * Methode permettant d'acceder au porcelet en dessous
	 * @return le porcelet en dessous : Null si c'est une case, un porcelet sinon
	 */
	public IRecepteur quiEstEnDessous();
	
	/** 
	 * Methode qui retourne la case sur laquelle se trouve le porcelet
	 * renvoie null si le recepteur est une case
	 **/
	public ICase retourneLaCase() ;
	
	/**
	 * Methode permettant d'acceder au porcelet au dessus
	 * @return le porcelet au dessus : Null si il n'y a personne, un porcelet sinon
	 */
	public IRecepteur quiEstAuDessus();
	
	/** 
	 * Predicat pour tester si le porcelet occupe la case
	 **/
	public boolean estSurLaCase(ICase c) ;
	
	/**
	 * Methode utilisee uniquement pour les porcelets
	 * @return le joueur proprietaire du porcelet
	 */
	public IJoueur quiEstMonMaitre();

}
