package russelBand.factory.impl;

import russelBand.factory.IPorceletFactory;
import russelBand.service.IPorcelet;
import russelBand.service.impl.PorceletImpl;

public class PorceletImplFactory implements IPorceletFactory {

	
	/** 
	 * {@inheritDoc}
	 * */
	@Override
	public IPorcelet create() {
		return new PorceletImpl();
	}

}
