package russelBand.service;


/**
 * @author tarik
 *
 */
public interface IPorcelet extends IRecepteur{
	

	
	/** Méthode permettant a un porcelet d'oublier le recepteur (porcelet ou case) en dessous 
	 *  de lui (oublier le lien vers le bas)
	 */
	public void oublier();
	
	
	
	/** Methode permettant a un 
	 *  porcelet d'avancer sur une case 
	 *  (la case peut deja etre occupee par un autre porc)
	 */
	public void avancer(ICase c);
	
	
	
	/** Methode permettant a un 
	 *  porcelet d'avancer d'une case
	 */
	public void avancer();
	
	
	
	/**
	 * Predicat pour tester la presence d'un porcelet sur une case 
	 * @param c uneCase
	 * @return TRUE si le porcelet se trouve sur la case c, FALSE sinon
	 */
	public boolean estSurLaCase(ICase c);

	
	/** 
	 * Predicat pour tester si le porcelet se trouve sous le porcelet en parametre
	 * @param p un porcelet
	 * @return TRUE si le porcelet se trouve sur le porcelet, FALSE sinon
	 **/
	public boolean estSous(IPorcelet p);
	
	
	/**
	 * Un porcelet peut monter sur un autre porcelet
	 * @param porcelet2
	 * @return TRUE si le porcelet se trouve sur le dos du porcelet, FALSE sinon
	 */
	public boolean estMonteeSur(IPorcelet porcelet2);
	

	
	/**
	 * Methode permettant d'affecter une case a un porcelet
	 */ 
	public void initPosition(IRecepteur r);
	
	
	
	/** Methode permettant de recuperer le joueur qui joue avec le porcelet
	 * @return le joueur 
	 */
	public IJoueur quiEstMonMaitre();
	
	
	/**Methode permettant d'attribuer a un joueur un porcelet
	 * @param j le joueur a qui on attribue le porcelet
	 */
	public void setJoueur(IJoueur j);
}
