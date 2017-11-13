package russelBand.factory;

import russelBand.service.ICase;

public interface ICaseFactory {
	
	/**
	 * Creation d'une case
	 * @return une case
	 */
	public ICase create();

}
