package russelBand.factory.impl;

import russelBand.factory.ICarteFactory;
import russelBand.service.ICarte;
import russelBand.service.impl.CarteImpl;

public class CarteImplFactory implements ICarteFactory {

	/** 
	 * {@inheritDoc}
	 **/
	@Override
	public ICarte create() {
		return new CarteImpl();
	}

}
