package russelBand.service;

public interface ICarte {
	
	/**
	 * Recupere la carte suivante
	 * @return la carte suivante
	 */
	public ICarte suivante();
	
	/**
	 * Recupere la premiere case de la carte
	 * @return la premiere case de la carte
	 */
	public ICase premiereCase();
	
	/**
	 * Recupere la deuxieme case de la carte
	 * @return la deuxieme case de la carte
	 */
	public ICase deuxiemeCase();
	
	/**
	 * Recupere la troisieme case de la carte
	 * @return la troisieme case de la carte
	 */
	public ICase troisiemeCase();
	
	/**
	 * Recupere le numero de la carte dans le plateau
	 * @return le numero de la carte
	 */
	public int donneTonNumero();
	
	/**
	 * Recupere les cases de notre carte
	 * @return les cases qui composent la carte
	 */
	public ICase[] mesCases();
	
	/**
	 * Injection de la dependance du plateau de jeu
	 * @param plateau le plateau de jeu qui contient la carte
	 */
	public void affecterPlateau(IPlateau plateau);
	
	/**
	 * Injection de la dependance des cases de la carte
	 * @param c1 la premiere case
	 * @param c2 la deuxieme case
	 * @param c3 la troisieme case
	 */
	public void affecterCases(ICase c1, ICase c2, ICase c3);
}
