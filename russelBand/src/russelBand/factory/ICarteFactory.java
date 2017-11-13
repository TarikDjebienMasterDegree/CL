package russelBand.factory;

import russelBand.service.ICarte;

public interface ICarteFactory {

	/**
	 * Creation d'une carte
	 * @return un objet Carte
	 */
	public ICarte create();
}
