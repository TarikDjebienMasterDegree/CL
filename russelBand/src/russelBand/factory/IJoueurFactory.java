package russelBand.factory;

import russelBand.service.IJoueur;

public interface IJoueurFactory {

	/**
	 * Creation d'un joueur
	 * @param playerName le nom du joueur
	 * @return un objet joueur 
	 */
	public IJoueur create(String playerName);
	
}
