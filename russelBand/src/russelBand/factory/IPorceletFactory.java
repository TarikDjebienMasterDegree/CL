package russelBand.factory;

import russelBand.service.IPorcelet;

public interface IPorceletFactory {
	
	/**
	 * Creation d'un porcelet
	 * @return le porcelet
	 */
	public IPorcelet create();

}
