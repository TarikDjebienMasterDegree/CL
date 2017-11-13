package russelBand.service;


public interface ICase extends IRecepteur{

	/**	
	 * Methode qui permet a la case de recevoir un porcelet
	 * @param p le porcelet que l'on pose sur la case
	 */
	public void recevoir(IPorcelet p) ;
	
	/**	Methode qui renvoie soit le porcelet si la case est occupee
	 *  soit la case elle meme dans le cas ou il n'y a pas de porc sur la case
	 */
	public IRecepteur quiEstAuSommet();
	
	/**	Methode qui renvoie la case suivante de la case en cours
	 */
	public ICase suivante();
	
	/**	
	 * Injection de dependances du porcelet
	 * @param porceletAuDessus le porcelet qui se trouve sur la case
	 */
	public void initCase(IPorcelet porceletAudessus);
	
	/**
	 * Retourne la carte de la case
	 * @return la carte de la case
	 */
	public ICarte retourneLaCarte();

	/**
	 * Injection de dependance de la Carte
	 * @param carteDeLaCase la carte de la case
	 */
	public void affecterCarte(ICarte carteDeLaCase);
	
	/**
	 * Injection de dependance de l'indice de la case
	 * @param indice l'indice de la case
	 */
	public void changerIndice(int indice);
	
	/**
	 * Recupere l'indice de la case
	 * @return l'indice de la case
	 */
	public int donneTonIndice();
		
}
